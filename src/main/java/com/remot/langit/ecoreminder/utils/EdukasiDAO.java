package com.remot.langit.ecoreminder.utils;

import com.remot.langit.ecoreminder.model.Edukasi;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author WIN 10
 */
public class EdukasiDAO extends Database {
    public void create() {
        this.getCon();
        try {
            String query = "CREATE TABLE edukasi ("
                    + "id_edukasi VARCHAR(36) PRIMARY KEY,"
                    + "judul VARCHAR(50),"
                    + "materi TEXT,"
                    + "referensi VARCHAR(50),"
                    + "id_user VARCHAR(36),"
                    + "FOREIGN KEY (id_user) REFERENCES user(id_user))";
            con.prepareStatement(query).executeUpdate();
        } catch(SQLException e) {
            System.err.println("Error create table: " + e.getMessage() );
        } finally {
            this.close();
        }
    }
    public void update(Edukasi edukasi) {
        this.getCon();
        try {
            String query = "UPDATE edukasi " +
                    "SET judul = '%s', materi = '%s', " +
                    "referensi = '%s', id_user = '%s' " +
                    "WHERE id_edukasi = '%s'";
            query = String.format(query,
                    edukasi.getJudul(),
                    edukasi.getMateri(),
                    edukasi.getReferensi(),
                    edukasi.getIdPenyusun(),
                    edukasi.getId());
            con.prepareStatement(query).executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error update edukasi : " + e.getMessage());
        } finally {
            this.close();
        }
    }

    public void insert(Edukasi edukasi) {
        this.getCon();
        try {
            String query = "INSERT INTO edukasi"
                    +"(id_edukasi, judul, materi, referensi, id_user) VALUES "
                    +"('%s', '%s', '%s', '%s', '%s')";
            query = String.format(query,
                    edukasi.getId(),
                    edukasi.getJudul(),
                    edukasi.getMateri(),
                    edukasi.getReferensi(),
                    edukasi.getIdPenyusun());
            con.prepareStatement(query).executeUpdate();
        } catch(SQLException e) {
            System.err.println("Error insert edukasi table: " + e.getMessage() );
        } finally {
            this.close();
        }
    }



    public ArrayList<Edukasi> getAll() {
        ArrayList<Edukasi> result = new ArrayList<>();
        this.getCon();
        try {
            String query = "SELECT * FROM edukasi";

            res = con.prepareStatement(query).executeQuery();
            while (res.next()) {
                var edukasi = new Edukasi(
                        UUID.fromString(res.getString("id_edukasi")),
                        res.getString("judul"),
                        UUID.fromString(res.getString("id_user")),
                        res.getString("materi"),
                        res.getString("referensi")
                );
                result.add(edukasi);
            }
        } catch (SQLException e) {
            System.out.println("Error get edukasi : " + e.getMessage());
        } finally {
            this.close();
        }
        return result;
    }

    public void delete(Edukasi edukasi) {
        this.getCon();
        try {
            String query = "DELETE from edukasi WHERE id_edukasi = '%s'";
            query = String.format(query, edukasi.getId());

            con.prepareStatement(query).executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error delete edukasi : " + e.getMessage());
        } finally {
            this.close();
        }
    }
}

