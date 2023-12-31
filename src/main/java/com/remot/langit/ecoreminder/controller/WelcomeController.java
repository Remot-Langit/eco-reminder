package com.remot.langit.ecoreminder.controller;

import com.remot.langit.ecoreminder.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {

    @FXML
    private AnchorPane coba;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void switchToLogin(MouseEvent mouseEvent) throws IOException {
        App.setRoot("laman login");
    }
}

