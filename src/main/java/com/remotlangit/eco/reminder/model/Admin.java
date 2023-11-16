/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.remotlangit.eco.reminder.model;

/**
 *
 * @author WIN 10
 */
public class Admin extends User {
    public Admin(String username, String nama, String email, String password, String no_telp, String foto) {
        super(username, nama, email, password, no_telp, foto);
    }

    public void sendNotification(String judul, String cuplikan) {
        Notifikasi notif = new Notifikasi(judul, cuplikan);
        notif.show();
    }
}
