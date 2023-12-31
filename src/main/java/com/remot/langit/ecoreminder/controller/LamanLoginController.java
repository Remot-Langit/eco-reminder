package com.remot.langit.ecoreminder.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.remot.langit.ecoreminder.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class LamanLoginController implements Initializable {

    @FXML
    private Button click;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void toLogin(MouseEvent mouseEvent) throws IOException {
        App.setRoot("login");
    }
}

