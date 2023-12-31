package com.remot.langit.ecoreminder.utils;

import com.remot.langit.ecoreminder.model.User;
import com.remot.langit.ecoreminder.model.UserAdmin;
import com.remot.langit.ecoreminder.model.UserMember;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;


public class UserDAO extends Database {

    public void create() {
        this.getCon();
        try {
            String query = "CREATE TABLE user ("
                    + "id_user VARCHAR(36) PRIMARY KEY,"
                    + "username VARCHAR(50),"
                    + "password VARCHAR(100),"
                    + "nama VARCHAR(50),"
                    + "email VARCHAR(50),"
                    + "role ENUM('Admin', 'Member'))";
            con.prepareStatement(query).executeUpdate();
        } catch(SQLException e) {
            System.err.println("Error create table point: " + e.getMessage() );
        } finally {
            this.close();
        }
    }

    private void insertPoint(UserMember user) {
        this.getCon();
        try {
            String query = "INSERT INTO point "
                    + "(id_user, point) VALUES "
                    + "('%s', %d)";
            query = String.format(query, user.getId().toString(), user.getPoint());
            con.prepareStatement(query).executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error insert point: " + e.getMessage());
        } finally {
            this.close();
        }
    }
    public <T extends User> void insert(T user) {
        this.getCon();
        try {
            String query = user instanceof UserAdmin ?
                    "INSERT INTO user "
                            + "(id_user, username, password, nama, email, role) VALUES "
                            + "('%s', '%s', '%s', '%s', '%s', 'Admin')" :
                    "INSERT INTO user "
                            + "(id_user, username, password, nama, email, role) VALUES "
                            + "('%s', '%s', '%s', '%s', '%s', 'Member')";
            query = String.format(query,
                    user.getId(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getNama(),
                    user.getEmail());
            con.prepareStatement(query).executeUpdate();
            if (user instanceof UserMember userMember)
                this.insertPoint(userMember);
        } catch(SQLException e) {
            System.err.println("Error insert user: " + e.getMessage());
        } finally {
            this.close();
        }
    }

    public <T extends User> T searchById(String id) {
        T user = null;
        this.getCon();
        try {
            String query = "SELECT * FROM user WHERE id_user = '%s'";
            query = String.format(query, id);

            res = con.prepareStatement(query).executeQuery();
            if (res.next()) {
                var uid = UUID.fromString(id);
                var username = res.getString("username");
                var password = res.getString("password");
                var role = res.getString("role");
                var nama = res.getString("nama");
                var email = res.getString("email");
                if (role.equals("Admin")) user = (T)new UserAdmin(uid, username, nama, email, password);
                else user = (T) new UserMember(uid, username, nama, email, password, this.getPoint(uid));
            }
        } catch (SQLException e) {
            System.err.println("Error get user : " + e.getMessage());
        } finally {
            this.close();
        }
        return user;
    }

    public<T extends User> ArrayList<T> getAll() {
        ArrayList<T> all = new ArrayList<T>();
        this.getCon();
        try {
            String query = "SELECT * FROM user";
            res = con.prepareStatement(query).executeQuery();
            while (res.next()) {
                T user;
                var id = UUID.fromString(res.getString("id_user"));
                var username = res.getString("username");
                var role = res.getString("role");
                var nama = res.getString("nama");
                var email = res.getString("email");
                var password = res.getString("password");
                if (role.equals("Admin")) user = (T)new UserAdmin(id, username, nama, email, password);
                else user = (T) new UserMember(id, username, nama, email, password, this.getPoint(id));
                all.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Error get all user : " + e.getMessage());
            all = null;
        } finally {
            this.close();
        }
        return all;
    }


    private Integer getPoint(UUID id) {
        int point = 0;
        try {
            String query = "SELECT * FROM point WHERE id_user = '%s'";
            query = String.format(query, id.toString());

            var res = con.prepareStatement(query).executeQuery();
            if (res.next()) {
                point = res.getInt("point");
            }
        } catch (SQLException e) {
            System.out.println("Error get point : " + e.getMessage());
        }
        return point;
    }

    public <T extends User> T login(String usernamemail, String password) {
        T user = null;
        this.getCon();
        try {
            String query = "SELECT * FROM user WHERE username = '%s' OR email = '%s'";
            query = String.format(query, usernamemail, usernamemail);

            res = con.prepareStatement(query).executeQuery();
            if (res.next() && res.getString("password").equals(password)) {
                var id = UUID.fromString(res.getString("id_user"));
                var username = res.getString("username");
                var role = res.getString("role");
                var nama = res.getString("nama");
                var email = res.getString("email");
                if (role.equals("Admin")) user = (T)new UserAdmin(id, username, nama, email, password);
                else user = (T) new UserMember(id, username, nama, email, password, this.getPoint(id));
            }
        } catch (SQLException e) {
            System.out.println("Error get user : " + e.getMessage());
        } finally {
            this.close();
        }
        return user;
    }
}

