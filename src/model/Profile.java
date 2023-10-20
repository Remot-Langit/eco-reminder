package model;

public class Profile {
    private String nama;
    private String email;
    private String foto;
    private int point;

    public Profile(String nama, String email, String foto) {
        this.nama = nama;
        this.foto = foto;
        this.email = email;
    }

    public void addPoint(int point) {
        this.point += point;
    }

    public int getPoint() {
        return point;
    }

    // Menukar poin ke dalam voucher
    public void exchange() {
        // TODO
    }

    @Override
    public String toString() {
        return "Profile: \n" +
                "  nama  = '" + nama + '\'' + "\n" +
                "  email = '" + email + '\'' + "\n" +
                "  foto  = '" + foto + '\'' + "\n" +
                "  point = " + point + "\n";
    }
}
