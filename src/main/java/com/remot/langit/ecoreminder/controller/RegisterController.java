package com.remot.langit.ecoreminder.controller;

import com.remot.langit.ecoreminder.App;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    public PasswordField password;
    public TextField email;
    public TextField username;
    public TextField name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        password.setVisible(true);
    }

    public void toLogin(MouseEvent mouseEvent) throws IOException {
        App.setRoot("login");
    }

    public void submit(MouseEvent mouseEvent) throws IOException {
        if (username.getText().isEmpty() || password.getText().isEmpty() || name.getText().isEmpty() || email.getText().isEmpty()) {
            var alert = new Alert(Alert.AlertType.INFORMATION, "Tolong di isi semua ya ges ya!!!");
            alert.showAndWait();
            return;
        }
        var code = App.data.register(name, email, username, password);
        switch (code) {
            case USERNAME_AVAILABLE -> {
                var alert = new Alert(Alert.AlertType.ERROR, "username telah digunakan");
                alert.showAndWait();
            }
            case EMAIL_AVAILABLE -> {
                var alert = new Alert(Alert.AlertType.ERROR, "email telah digunakan");
                alert.showAndWait();
            }
            case FINE -> {
                App.setRoot("member/profile");
            }
            default -> {
                System.out.println(code);
            }
        }
    }
}
