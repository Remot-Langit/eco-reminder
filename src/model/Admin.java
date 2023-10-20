package model;

public class Admin extends User {
    public Admin(String username, String nama, String email, String password, String no_telp, String foto) {
        super(username, nama, email, password, no_telp, foto);
    }

    public void sendNotification(String judul, String cuplikan) {
        Notifikasi notif = new Notifikasi(judul, cuplikan);
        notif.show();
    }
}
