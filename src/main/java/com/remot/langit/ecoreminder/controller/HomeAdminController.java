package com.remot.langit.ecoreminder.controller;

import com.remot.langit.ecoreminder.App;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeAdminController implements Initializable {
    public Label name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText(String.format("%s!", App.data.getUser().getNama()));
    }

    public void toHome(MouseEvent mouseEvent) throws IOException {
    }

    public void toEducation(MouseEvent mouseEvent) throws IOException {
        App.setRoot("admin/education");
    }

    public void toChallange(MouseEvent mouseEvent) throws IOException {
        App.setRoot("admin/challange");
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        App.data.logout();
        App.setRoot("laman login");
    }
}
