/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.remotlangit.eco.reminder.model;

/**
 *
 * @author WIN 10
 */
public class Edukasi {
    private String judul;
    private String penyusun;
    private String materi;
    private String referensi;

    public Edukasi(String judul, String penyusun, String materi, String referensi) {
        this.judul = judul;
        this.penyusun = penyusun;
        this.materi = materi;
        this.referensi = referensi;
    }

    @Override
    public String toString() {
        return "Edukasi :\n" +
                "  judul = '" + penyusun + '\'' + "\n" +
                "  materi='" + materi + '\'' + "\n" +
                "  referensi='" + referensi + '\'' + "\n";
    }

    public String getJudul() {
        return judul;
    }

    public String getPenyusun() {
        return penyusun;
    }

    public String getMateri() {
        return materi;
    }

    public String getReferensi() {
        return referensi;
    }
}