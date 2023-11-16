/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.remotlangit.eco.reminder.model;

/**
 *
 * @author WIN 10
 */
public class Notifikasi {
    private String judul;
    private String cuplikan;

    public Notifikasi(String judul, String cuplikan) {
        this.judul = judul;
        this.cuplikan = cuplikan;
    }

    public void show() {
        System.out.println(this.judul);
        System.out.println("----------------");
        System.out.println(this.cuplikan);
    }

    public void sendNotification() {
        //TODO
    }
}