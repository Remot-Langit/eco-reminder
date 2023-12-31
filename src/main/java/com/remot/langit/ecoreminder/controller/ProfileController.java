package com.remot.langit.ecoreminder.controller;

import com.remot.langit.ecoreminder.App;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

    public Label nama;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nama.setText(App.data.getUser().getNama());
    }

    public void SwitchEdit(MouseEvent mouseEvent) {
    }

    public void SwitchChallenge(MouseEvent mouseEvent) throws IOException {
        App.setRoot("member/challange list");
    }

    public void SwitchCapaian(MouseEvent mouseEvent) throws IOException {
        App.setRoot("member/capaian");
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        App.setRoot("laman login");
    }

    public void switchEdukasi(MouseEvent mouseEvent) throws IOException {
        App.setRoot("member/education list");
    }

    public void switchRewards(MouseEvent mouseEvent) throws IOException {
        App.setRoot("member/rewards");
    }
}
