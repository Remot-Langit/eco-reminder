/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.remotlangit.eco.reminder.model;

/**
 *
 * @author WIN 10
 */
import java.time.LocalDate;

public class Challange {
    private String nama;
    private String deskripsi;
    private LocalDate start;
    private LocalDate current;

    private int jumlahHari;
    private int point;

    public Challange(String nama, String deskripsi, int jumlahHari, int point) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.jumlahHari = jumlahHari;
        this.point = point;
    }

    public void start() {
        this.start = LocalDate.now();
        this.current = LocalDate.now();
    }

    // TODO
    // inkrement start current setiap hari


    public int getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return  "Challange: \n" +
                "  Nama        : " + this.nama + "\n" +
                "  Deskripsi   : " + this.deskripsi + "\n" +
                "  Batas waktu : " + this.jumlahHari + "hari\n" +
                "  Poin        : " + this.point + "\n";
    }
}
