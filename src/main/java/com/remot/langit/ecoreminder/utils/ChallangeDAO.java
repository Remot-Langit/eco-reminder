package com.remot.langit.ecoreminder.utils;

import com.remot.langit.ecoreminder.model.Challange;
import com.remot.langit.ecoreminder.model.UserMember;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 @author WIN 10
 */
public class ChallangeDAO extends Database {
    public void create() {
        try {
            this.getCon();
            var query = "CREATE TABLE challange ("
                    + "id_challange VARCHAR(36) PRIMARY KEY,"
                    + "deskripsi TEXT,"
                    + "nama_challange VARCHAR(50),"
                    + "jumlah_hari INT,"
                    + "point INT,"
                    + "id_user VARCHAR(36),"
                    + "FOREIGN KEY (id_user) REFERENCES user(id_user))";
            con.prepareStatement(query).executeUpdate();
        } catch(SQLException e) {
            System.err.println("Error create challange table: " + e.getMessage() );
        } finally {
            this.close();
        }
    }

    public void insert(Challange challange) {
        this.getCon();
        try {
            String query = "INSERT INTO challange"
                    +"(id_challange, deskripsi, nama_challange, jumlah_hari, point, id_user) VALUES "
                    +"('%s', '%s', '%s', %d, %d, '%s')";
            query = String.format(query,
                    challange.getId(),
                    challange.getDeskripsi(),
                    challange.getNama(),
                    challange.getJumlahHari(),
                    challange.getPoint(),
                    challange.getIdPembuat());
            con.prepareStatement(query).executeUpdate();
        } catch(SQLException e) {
            System.err.println("Error insert challange table: " + e.getMessage() );
        } finally {
            this.close();
        }
    }

    public void update(Challange challange) {
        this.getCon();
        try {
            String query ="UPDATE challange "
                    +"SET deskripsi = '%s', nama_challange = '%s'," +
                    "jumlah_hari = %d, point = %d, id_user = '%s' " +
                    "WHERE id_challange = '%s'";
            query = String.format(query,
                    challange.getDeskripsi(),
                    challange.getNama(),
                    challange.getJumlahHari(),
                    challange.getPoint(),
                    challange.getIdPembuat(),
                    challange.getId());
            con.prepareStatement(query).executeUpdate();
        } catch(SQLException e) {
            System.err.println("Error insert challange table: " + e.getMessage() );
        } finally {
            this.close();
        }
    }

    public Challange searchById(String id) {
        Challange challange = null;
        this.getCon();
        try {
            String query = "SELECT * FROM challange WHERE id_challange = '%s'";
            query = String.format(query, id);

            res = con.prepareStatement(query).executeQuery();
            if (res.next()) {
                challange = new Challange(
                        UUID.fromString(id),
                        res.getString("nama_challange"),
                        res.getString("deskripsi"),
                        UUID.fromString(res.getString("id_user")),
                        res.getInt("jumlah_hari"),
                        res.getInt("point")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error get user : " + e.getMessage());
        } finally {
            this.close();
        }
        return challange;
    }

    public ArrayList<Challange> getAll() {
        ArrayList<Challange> result = new ArrayList<>();
        this.getCon();
        try {
            String query = "SELECT * FROM challange";

            res = con.prepareStatement(query).executeQuery();
            while (res.next()) {
                var challange = new Challange(
                        UUID.fromString(res.getString("id_challange")),
                        res.getString("nama_challange"),
                        res.getString("deskripsi"),
                        UUID.fromString(res.getString("id_user")),
                        res.getInt("jumlah_hari"),
                        res.getInt("point")
                );
                result.add(challange);
            }
        } catch (SQLException e) {
            System.out.println("Error get challange : " + e.getMessage());
        } finally {
            this.close();
        }
        return result;
    }

    //TODO get all unselected challange
    public ArrayList<Challange> getAllUnselected(UserMember user) {
        ArrayList<Challange> result = new ArrayList<>();
        this.getCon();
        try {
            String query = "SELECT " +
                    "challange.id_challange AS id_challlange, " +
                    "challange.nama_challange AS nama_challange, " +
                    "challange.deskripsi AS deskripsi, " +
                    "challange.id_user AS id_user, " +
                    "challange.jumlah_hari AS jumlah_hari, " +
                    "challange.point AS point " +
                    "FROM challange, capaian " +
                    "WHERE capaian.id_challange = challange.id_challange " +
                    "AND capaian.id_user != '%s'";
            query = String.format(query, user.getId());
            System.out.println(query);

            res = con.prepareStatement(query).executeQuery();
            while (res.next()) {
                var challange = new Challange(
                        UUID.fromString(res.getString("id_challange")),
                        res.getString("nama_challange"),
                        res.getString("deskripsi"),
                        UUID.fromString(res.getString("id_user")),
                        res.getInt("jumlah_hari"),
                        res.getInt("point")
                );
                result.add(challange);
            }
        } catch (SQLException e) {
            System.out.println("Error get challange : " + e.getMessage());
        } finally {
            this.close();
        }
        return result;
    }
    public void delete(Challange challange) {
        this.getCon();
        try {
            String query = "DELETE FROM challange WHERE id_challange = '%s'";
            query = String.format(query, challange.getId());
            con.prepareStatement(query).executeUpdate();
        } catch(SQLException e) {
            System.err.println("Error deleting challange : " + e.getMessage());
        } finally {
            this.close();
        }
    }
}

