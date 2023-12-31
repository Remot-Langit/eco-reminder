package com.remot.langit.ecoreminder.utils;

import com.remot.langit.ecoreminder.model.Capaian;
import com.remot.langit.ecoreminder.model.Challange;
import com.remot.langit.ecoreminder.model.UserMember;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author WIN 10
 */
public class CapaianDAO extends Database {
    public void create() {
        this.getCon();
        try {
            String query = "CREATE TABLE capaian ("
                    + "id_capaian VARCHAR(36) PRIMARY KEY,"
                    + "id_user VARCHAR(36),"
                    + "id_challange VARCHAR(36),"
                    + "FOREIGN KEY (id_user) REFERENCES user(id_user)";
            con.prepareStatement(query).executeUpdate();
        } catch(SQLException e) {
            System.err.println("Error create table: " + e.getMessage() );
        } finally {
            this.close();
        }
    }

    public void insert (UserMember user, Challange challange) {
        this.getCon();
        try {
            String query = "INSERT INTO capaian"
                    +"(id_capaian, id_user, id_challange) VALUES "
                    +"('%s', '%s', '%s')";
            query = String.format(query,
                    challange.getId(),
                    user.getId(),
                    challange.getId());
            con.prepareStatement(query).executeUpdate();
        } catch(SQLException e) {
            System.err.println("Error insert capaian table: " + e.getMessage() );
        }
    }

    public ArrayList<Capaian> searchByUserId(String id) {
        ArrayList<Capaian> capaians = new ArrayList<>();
        this.getCon();
        try {
            String query = "SELECT " +
                    "capaian.id_capaian as id_capaian, " +
                    "capaian.id_user as id_user, " +
                    "capaian.id_challange as id_challange, " +
                    "capaian.finish as finish, " +
                    "capaian.start as start, " +
                    "capaian.point as point, " +
                    "challange.nama_challange AS nama_challange, " +
                    "challange.jumlah_hari AS batas_waktu, " +
                    "TIMESTAMPDIFF(DAY, capaian.start, capaian.start + INTERVAL challange.jumlah_hari DAY) AS remaining " +
                    "FROM capaian, challange " +
                    "WHERE capaian.id_challange = challange.id_challange " +
                    "AND capaian.id_user = '%s'";
            query = String.format(query, id);
            System.out.println(query);

            res = con.prepareStatement(query).executeQuery();
            while (res.next()) {
                var capaian = new Capaian(
                        res.getString("id_capaian"),
                        res.getString("nama_challange"),
                        res.getString("id_user"),
                        res.getString("id_challange"),
                        res.getBoolean("finish"),
                        res.getTimestamp("start"),
                        res.getInt("batas_waktu"),
                        res.getInt("remaining")
                );
                capaians.add(capaian);

            }
        } catch (SQLException e) {
            System.err.println("Error get user : " + e.getMessage());
        } finally {
            this.close();
        }
        return capaians;
    }

    public int getPoint(UserMember user) {
        this.getCon();
        var result = 0;
        try {
            String query = String.format("SELECT SUM(capaian.point) AS all_point FROM capaian WHERE id_user = '%s'", user.getId());
            res = con.prepareStatement(query).executeQuery();
            if (res.next()) {
                result = res.getInt("all_point");
            }
        } catch (SQLException e) {
            System.err.println("Error can't get point : " + e.getMessage());
        } finally {
            this.close();
        }
        return result;
    }
}

