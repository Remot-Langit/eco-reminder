package com.remot.langit.ecoreminder.model;

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
