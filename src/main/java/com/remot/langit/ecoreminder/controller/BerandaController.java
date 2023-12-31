package com.remot.langit.ecoreminder.controller;

import com.remot.langit.ecoreminder.App;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class BerandaController {

    public void rewards(MouseEvent mouseEvent) throws IOException {
        App.setRoot("member/rewards");
    }

    public void toChallange(MouseEvent mouseEvent) throws IOException {
        App.setRoot("member/challange pages");
    }

    public void toEducation(MouseEvent mouseEvent) throws IOException {
        App.setRoot("member/education list");
    }

    public void toCapaian(MouseEvent mouseEvent) throws IOException {
        App.setRoot("member/capaian");
    }

    public void toReward(MouseEvent mouseEvent) throws IOException {
        App.setRoot("member/rewards");
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        App.setRoot("laman login");

    }

    public void toProfile(MouseEvent mouseEvent) throws IOException {
        App.setRoot("member/profile");
    }
}
