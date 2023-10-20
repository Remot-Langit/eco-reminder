package model;

public class User {
    private String username;
    private String password;
    private String email;
    private String nama;
    private String no_telp;
    private String foto;
    private Profile profile;

    public User(String username, String nama, String email, String password, String no_telp, String foto) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nama = nama;
        this.no_telp = no_telp;
        this.foto = foto;

        this.profile = new Profile(nama, email, foto);
    }

    public void addEdukasi(ListEdukasi listEdukasi, String judul, String materi, String referensi) {
        Edukasi ed = new Edukasi(judul, this.nama, materi, referensi);
        listEdukasi.addEdukasi(ed);

        // TODO agar admin dapat memvalidasi edukasi yang disarankan user
    }

    public void addChallange(ListChallange listChallange, String nama, String deskripsi, int jumlahHari, int point) {
        Challange c = new Challange(nama, deskripsi, jumlahHari, point);
        listChallange.addChallange(c);

        // TODO agar admin dapat memfalidasi challange yang disarankan user
    }

    public Profile getProfile() {
        return profile;
    }

    // TODO login logout
}
