package com.remot.langit.ecoreminder.model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Capaian {
    private String idChallange;
    private String namaChallange;
    private String idUser;
    private String idCapaian;
    private boolean finish;
    private Timestamp start;
    private int batasWaktu;
    private int remaining;

    public Capaian(String idCapaian, String idUser, String idChallange, boolean finish, Timestamp start, int remaining) {
        this.idChallange = idChallange;
        this.idUser = idUser;
        this.idCapaian = idCapaian;
        this.finish = finish;
        this.start = start;
        this.remaining = remaining;
    }

    public Capaian(String idCapaian, String namaChallange, String idUser, String idChallange, boolean finish, Timestamp start, int remaining) {
        this.idChallange = idChallange;
        this.namaChallange = namaChallange;
        this.idUser = idUser;
        this.idCapaian = idCapaian;
        this.finish = finish;
        this.start = start;
        this.remaining = remaining;
    }

    public Capaian(String idChallange, String namaChallange, String idUser, String idCapaian, boolean finish, Timestamp start, int batasWaktu, int remaining) {
        this.idChallange = idChallange;
        this.namaChallange = namaChallange;
        this.idUser = idUser;
        this.idCapaian = idCapaian;
        this.finish = finish;
        this.start = start;
        this.batasWaktu = batasWaktu;
        this.remaining = remaining;
    }

    public void setBatasWaktu(int batasWaktu) {
        this.batasWaktu = batasWaktu;
    }

    public int getBatasWaktu() {
        return batasWaktu;
    }

    public String getNamaChallange() {
        return namaChallange;
    }

    public void setNamaChallange(String namaChallange) {
        this.namaChallange = namaChallange;
    }

    public void setIdChallange(String idChallange) {
        this.idChallange = idChallange;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setIdCapaian(String idCapaian) {
        this.idCapaian = idCapaian;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public String getIdChallange() {
        return idChallange;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getIdCapaian() {
        return idCapaian;
    }

    public boolean isFinish() {
        return finish;
    }

    public Timestamp getStart() {
        return start;
    }

    public int getRemaining() {
        return remaining;
    }
}
