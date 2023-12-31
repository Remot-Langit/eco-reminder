package com.remot.langit.ecoreminder.controller;

import com.remot.langit.ecoreminder.App;
import com.remot.langit.ecoreminder.model.Challange;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListChallangeController implements Initializable {
    public ScrollPane containerList;
    public VBox box;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        App.data.refreshChallange();
        App.setTitle("List Challange!!");
        this.get();
    }

    private void get() {
        var currentHeight = 40.0;
        box.setPrefWidth(493.0);
        for (var data: App.data.getListChallange()) {
            box.setPrefHeight(currentHeight += 25);
            if (currentHeight >= 285 && box.getPrefWidth() > 480.0)
                box.setPrefWidth(475.0);
            var challange = (Challange)data;
            var container = new VBox();
            container.setPrefWidth(423.0);
            container.setPrefHeight(25.0);
            container.setAlignment(Pos.CENTER);
            container.setStyle("-fx-background-color: #9ab496; -fx-background-radius: 5px");
            var text = new Text();
            text.setText(challange.getNama());
            text.setTextAlignment(TextAlignment.CENTER);
            text.setStrokeType(StrokeType.OUTSIDE);
            text.setStrokeWidth(0.0);
            container.getChildren().add(text);
            box.getChildren().add(container);
            container.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    App.data.setCurrentChallange(challange);
                    try {
                        App.setRoot("member/challange pages");
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                }
            });
        }
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        App.setRoot("member/profile");
    }

    public void toChallange(MouseEvent mouseEvent) throws IOException {
        App.setRoot("member/challange pages");
    }
}
