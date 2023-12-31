package com.remot.langit.ecoreminder.utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    protected PreparedStatement st;
    protected Connection con;
    protected ResultSet res;
    protected String dbHost;
    protected String dbUsername;
    protected String dbPassword;
    protected String dbName;

    public Database() {
        var dotenv = Dotenv.configure()
                .directory("./")
                .load();
        this.dbHost = dotenv.get("DB_HOST");
        this.dbUsername = dotenv.get("DB_USERNAME");
        this.dbPassword = dotenv.get("DB_PASSWORD");
        this.dbName = dotenv.get("DB_NAME");
    }

    public Connection getCon() {
        Properties props = new Properties();
        props.setProperty("user", dbUsername);
        props.setProperty("password", dbPassword);
        props.setProperty("useSSL", "true");
        try {
            String url = "jdbc:mysql://" + dbHost + "/" + dbName;
            con = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            System.err.println("Waduh gak bisa konek nih : " + e.getMessage());
            System.exit(1);
        }
        return con;
    }
    public void testCon() {
        this.getCon();
        try (Statement stat = con.createStatement(); ResultSet result = stat.executeQuery("SHOW TABLES")) {
            System.out.println("Koneksi sukses");

            if (result.next()) {
                System.out.println("Tables in the database:");
                do {
                    System.out.println("- " + result.getString(1));
                } while (result.next());
            } else {
                System.out.println("Connected successfully. No tables found in the database.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        try {
            if(this.res != null) this.res.close();
            if(this.con != null) this.con.close();
//            this.res && this.res.close();
//            this.con && this.con.close();
        } catch(SQLException e) {
            System.out.println("cant close");
        }
    }
}

