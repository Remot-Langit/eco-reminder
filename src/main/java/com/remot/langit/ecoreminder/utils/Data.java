package com.remot.langit.ecoreminder.utils;

import com.remot.langit.ecoreminder.model.*;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class Data<T extends User> {
    private T user;
    private ArrayList<Challange> listChallange;
    private ArrayList<Edukasi> listEdukasi;
    private ArrayList<T> listUser;
    private final CapaianDAO capaianDAO;
    private final ChallangeDAO challangeDAO;
    private final EdukasiDAO edukasiDAO;
    private final UserDAO userDAO;
    private Challange currentChallange;
    private ArrayList<Capaian> capaian;
    private int currentIndexEdukasi;

    public void setCurrentIndexEdukasi(int currentIndexEdukasi) {
        this.currentIndexEdukasi = currentIndexEdukasi;
    }

    public int getCurrentIndexEdukasi() {
        return currentIndexEdukasi;
    }

    public Challange getCurrentChallange() {
        return currentChallange;
    }

    public void setCurrentChallange(Challange currentChallange) {
        this.currentChallange = currentChallange;
    }

    public Data() {
        this.capaianDAO = new CapaianDAO();
        this.challangeDAO = new ChallangeDAO();
        this.edukasiDAO = new EdukasiDAO();
        this.userDAO = new UserDAO();
        this.listUser = userDAO.getAll();
    }

    public LoginInfo login(TextField emailusername, PasswordField password) {
        if (this.listUser == null)
            return LoginInfo.SUSPENDED_DATABASE;
        if (!this.getUsernameEmail(emailusername.getText()))
            return LoginInfo.USERNAME_EMAIL_NOT_AVAILABLE;
        if (this.user.getPassword().equals(password.getText()))
            return LoginInfo.FINE;
        this.user = null;
        return LoginInfo.WRONG_PASSWORD;
    }
    public LoginInfo register(TextField nama, TextField email, TextField username, PasswordField password) {
        if (this.listUser == null)
            return LoginInfo.SUSPENDED_DATABASE;
        if (this.getUsername(username.getText()))
            return LoginInfo.USERNAME_AVAILABLE;
        if (this.getEmail(email.getText()))
            return LoginInfo.EMAIL_AVAILABLE;
        var user = new UserMember(username.getText(), nama.getText(), email.getText(), password.getText());
        this.userDAO.insert(user);
        this.user = (T) user;
        this.listUser.add((T) user);
        return LoginInfo.FINE;
    }

    public void addChallange(TextField nama, TextArea deskripsi, ChoiceBox<String> batas, ChoiceBox<Integer> point) {
        int batasWaktu = 0;
        switch (batas.getSelectionModel().getSelectedItem()) {
            case "1 hari" -> batasWaktu = 1;
            case "2 hari" -> batasWaktu = 2;
            case "3 hari" -> batasWaktu = 3;
            case "4 hari" -> batasWaktu = 4;
            case "5 hari" -> batasWaktu = 5;
            case "6 hari" -> batasWaktu = 6;
            case "7 hari" -> batasWaktu = 7;
        }

        var challange = new Challange(nama.getText(), deskripsi.getText(), this.user.getId(), batasWaktu, point.getSelectionModel().getSelectedItem());
        this.challangeDAO.insert(challange);
        this.listChallange.add(challange);
        nama.setText("");
        deskripsi.setText("");
        batas.getSelectionModel().select(0);
        point.getSelectionModel().select(0);
    }

    public void editChallange(Challange chal, TextField nama, TextArea deskripsi, ChoiceBox<String> batas, ChoiceBox<Integer> point) {
        int batasWaktu = 0;
        switch (batas.getSelectionModel().getSelectedItem()) {
            case "1 hari" -> batasWaktu = 1;
            case "2 hari" -> batasWaktu = 2;
            case "3 hari" -> batasWaktu = 3;
            case "4 hari" -> batasWaktu = 4;
            case "5 hari" -> batasWaktu = 5;
            case "6 hari" -> batasWaktu = 6;
            case "7 hari" -> batasWaktu = 7;
        }

        var challange = new Challange(chal.getId(), nama.getText(), deskripsi.getText(), this.user.getId(), batasWaktu, point.getSelectionModel().getSelectedItem());
        this.challangeDAO.update(challange);
    }

    public Optional<ButtonType> onGoing() {
        var alert = new Alert(Alert.AlertType.INFORMATION, "Fitur dalam pengembangan");
        return alert.showAndWait();
    }

    public int getPoint() {
        return capaianDAO.getPoint((UserMember) this.user);
    }
    public void editEducation(Edukasi edukasi, TextField judul, TextArea materi, TextField referensi) {
        var edu = new Edukasi(edukasi.getId(), judul.getText(), this.user.getId(), materi.getText(), referensi.getText());
        this.edukasiDAO.update(edu);
    }

    public void addEdukasi(TextField judul, TextArea materi, TextField referensi) {
        var edukasi = new Edukasi(judul.getText(), this.user.getId(), materi.getText(), referensi.getText());
        this.edukasiDAO.insert(edukasi);
    }

    public void deleteChallange(Challange challange) {
        this.challangeDAO.delete(challange);
    }

    public void deleteEducation(Edukasi edukasi) {
        this.edukasiDAO.delete(edukasi);
    }



    private Boolean getUsername(String username) {
        if (this.listUser != null)
            for (var user: this.listUser)
                if (user.getUsername().equals(username))
                    return true;
        return false;
    }

    private Boolean getUsernameEmail(String usernameEmail) {
        if (this.listUser != null)
            for (var user: this.listUser)
                if (user.getUsername().equals(usernameEmail) || (user.getEmail().equals(usernameEmail))) {
                    this.user = user;
                    return true;
                }
        return false;
    }

    public String getUsernamePenyusun(UUID id) {
        if (this.listUser != null)
            for (var user: this.listUser)
                if (user.getId().equals(id))
                    return user.getUsername();
        return "";
    }

    public void refreshCapaian() {
        if (this.user != null)
            this.capaian = this.capaianDAO.searchByUserId(this.user.getId().toString());
    }

    public ArrayList<Capaian> getCapaian() {
        //this.refreshCapaian();
        return capaian;
    }

    private Boolean isAdmin(String username) {
        if (this.listUser != null)
            for (var user: this.listUser)
                if (user.getUsername().equals(username) && user instanceof UserAdmin)
                    return true;
        return false;
    }

    private Boolean getEmail(String email) {
        if (this.listUser != null)
            for (var user: this.listUser)
                if (user.getEmail().equals(email))
                    return true;
        return false;
    }
    public void logout() {
        this.user = null;
    }
    public void refreshChallange() {
        this.refreshCapaian();
        this.listChallange = new ArrayList<>();
        for(Challange challange: challangeDAO.getAll()) {
            var found = false;
            for (Capaian capaian1: capaian) {
                if (challange.getId().toString().equals(capaian1.getIdChallange()) && capaian1.getIdUser().equals(this.user.getId().toString())) {
                    found = true;
                    break;
                }
            };
            if (!found) {
                this.listChallange.add(challange);
            }
        }
    }

    private void refreshUser() {
        this.listUser = userDAO.getAll();
    }


    public void refreshEdukasi() {
        this.listEdukasi = edukasiDAO.getAll();
    }

    public ArrayList<Challange> getListChallange() {
        //this.refreshChallange();
        return listChallange;
    }

    public ArrayList<Edukasi> getListEdukasi() {
        //this.refreshEdukasi();
        return listEdukasi;
    }

    public void setUser(T user) {
        this.user = user;
    }

    public T getUser() {
        return user;
    }
}
