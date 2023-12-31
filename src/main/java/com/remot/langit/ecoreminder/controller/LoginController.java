package com.remot.langit.ecoreminder.controller;

import com.remot.langit.ecoreminder.App;
import com.remot.langit.ecoreminder.model.UserAdmin;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public TextField username;
    public PasswordField password;
    public CheckBox showPass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void toRegister(MouseEvent mouseEvent) throws IOException {
        App.setRoot("register");
    }

    public void submit(MouseEvent mouseEvent) throws IOException {
        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            var alert = new Alert(Alert.AlertType.INFORMATION, "Tolong di isi semua ya ges ya!!!");
            alert.showAndWait();
            return;
        }
        var code = App.data.login(username, password);
        switch (code) {
            case USERNAME_EMAIL_NOT_AVAILABLE -> {
                var alert = new Alert(Alert.AlertType.ERROR, "Username / Email tidak ditemukan!!");
                alert.showAndWait();
            }
            case WRONG_PASSWORD -> {
                var alert = new Alert(Alert.AlertType.ERROR, "Password salah!!!");
                alert.show();
            }
            case FINE -> {
                if (App.data.getUser() instanceof UserAdmin)
                    App.setRoot("admin/home");
                else
                    App.setRoot("member/profile");
            }
            default -> {
                username.setText("");
                password.setText("");
            }
        }
    }
}
