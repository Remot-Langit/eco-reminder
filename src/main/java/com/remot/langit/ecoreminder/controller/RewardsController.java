package com.remot.langit.ecoreminder.controller;

import com.remot.langit.ecoreminder.App;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RewardsController implements Initializable {
    public Text poin;

    public void toOvo(MouseEvent mouseEvent) {
        App.data.onGoing();
    }


    public void toShopee(MouseEvent mouseEvent) {
        App.data.onGoing();
    }

    public void toDana(MouseEvent mouseEvent) {
        App.data.onGoing();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        poin.setText("" + App.data.getPoint());
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        App.setRoot("member/profile");
    }
}
