package com.remot.langit.ecoreminder.model;

import java.util.UUID;

public class Edukasi {
    private UUID id;
    private String judul;
    private UUID idPenyusun;
    private String materi;
    private String cuplikan;
    private String referensi;

    public Edukasi(String judul, UUID idPenyusun, String materi, String referensi) {
        this.judul = judul;
        this.idPenyusun = idPenyusun;
        this.materi = materi;
        this.cuplikan = this.materi.length() > 50 ? this.materi.substring(0, 47) + "..." : this.materi;
        this.referensi = referensi;
        this.id = UUID.randomUUID();
    }

    public String getCuplikan() {
        return cuplikan;
    }

    public void setCuplikan(String cuplikan) {
        this.cuplikan = cuplikan;
    }

    public void setCuplikan() {
        this.cuplikan = this.materi.length() > 50 ? this.materi.substring(0, 47) + "..." : this.materi;
    }

    public Edukasi(UUID id, String judul, UUID idPenyusun, String materi, String referensi) {
        this.judul = judul;
        this.idPenyusun = idPenyusun;
        this.materi = materi;
        this.cuplikan = this.materi.length() > 50 ? this.materi.substring(0, 47) + "..." : this.materi;
        this.referensi = referensi;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public UUID getIdPenyusun() {
        return idPenyusun;
    }

    public String getMateri() {
        return materi;
    }

    public String getReferensi() {
        return referensi;
    }
}
