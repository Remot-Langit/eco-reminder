import model.Admin;
import model.ListChallange;
import model.ListEdukasi;
import model.User;

public class Main {
    public static void main(String[] args) {
        User us1 = new User("user1", "useran", "user@upi.edu", "pass", "0880238208", "https://google.com");
        Admin admin = new Admin("admin", "adminan", "admin@upi.edu", "123", "1028392", "https://facebook.com");
        ListEdukasi listEdukasi = new ListEdukasi();
        ListChallange listChallange = new ListChallange();

        admin.sendNotification("Bahaya buang sampah sembarangan", "sampah adalah sebuah benda yang .......");
        admin.addChallange(listChallange, "Membuang sampah ke tempatnya", "Pengguna membuang sampah pada tempat yang memang untuk membuang sampah", 30, 1000);
        us1.addEdukasi(listEdukasi, "Bahaya buang sampah sembarangan", "lorem ipsum dolor amet sit color di consecterum bala bala", "https://example.com");
        System.out.println(us1.getProfile());
        System.out.println(listEdukasi);
        System.out.println(listChallange);
    }
}