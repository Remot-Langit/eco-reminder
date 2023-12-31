package com.remot.langit.ecoreminder.model;

import java.util.UUID;

public class User {
    private String username;
    private String password;
    private String email;
    private String nama;
    private UUID id;

    public User(String username, String nama, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nama = nama;
        this.id = UUID.randomUUID();
    }

    public User(UUID id, String username, String nama, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nama = nama;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getNama() {
        return nama;
    }

    public UUID getId() {
        return id;
    }
}
