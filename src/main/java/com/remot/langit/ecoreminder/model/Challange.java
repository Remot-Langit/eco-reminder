package com.remot.langit.ecoreminder.model;

import java.time.LocalDate;
import java.util.UUID;

public class Challange {
    private UUID id;
    private String nama;
    private String deskripsi;
    private LocalDate start;
    private LocalDate current;
    private UUID idPembuat;

    private int jumlahHari;
    private int point;

    public Challange(String nama, String deskripsi, UUID idPembuat, int jumlahHari, int point) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.jumlahHari = jumlahHari;
        this.point = point;
        this.idPembuat = idPembuat;
        this.id = UUID.randomUUID();
    }

    public Challange(UUID id, String nama, String deskripsi, UUID idPembuat, int jumlahHari, int point) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.jumlahHari = jumlahHari;
        this.point = point;
        this.idPembuat = idPembuat;
        this.id = id;
    }

    public UUID getIdPembuat() {
        return idPembuat;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getCurrent() {
        return current;
    }

    public int getJumlahHari() {
        return jumlahHari;
    }

    public UUID getId() {
        return id;
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

}
