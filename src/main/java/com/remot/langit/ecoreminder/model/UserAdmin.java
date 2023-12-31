package com.remot.langit.ecoreminder.model;

import java.util.UUID;

/**
 *
 * @author WIN 10
 */
public class UserAdmin extends User {
    public Edukasi addEdukasi(String judul, String materi, String referensi) {
        Edukasi ed = new Edukasi(judul, this.getId(), materi, referensi);
        // listEdukasi.addEdukasi(ed);
        return ed;

        // TODO agar admin dapat memvalidasi edukasi yang disarankan user
    }

    public Challange addChallange(String nama, String deskripsi, int jumlahHari, int point) {
        Challange c = new Challange(nama, deskripsi, this.getId(), jumlahHari, point);
        return c;
        //listChallange.addChallange(c);

        // TODO agar admin dapat memfalidasi challange yang disarankan user
    }
    public UserAdmin(String username, String nama, String email, String password) {
        super(username, nama, email, password);
    }

    public UserAdmin(UUID id, String username, String nama, String email, String password) {
        super(id, username, nama, email, password);
    }

    public void sendNotification(String judul, String cuplikan) {
        Notifikasi notif = new Notifikasi(judul, cuplikan);
        notif.show();
    }
}

