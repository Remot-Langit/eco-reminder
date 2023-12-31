package com.remot.langit.ecoreminder.controller;

import com.remot.langit.ecoreminder.App;
import com.remot.langit.ecoreminder.model.Capaian;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CapaianController implements Initializable {
    public VBox progresslist;
    public VBox finishList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        App.data.refreshCapaian();
        finishList.getChildren().clear();
        progresslist.getChildren().clear();
        for (var data: App.data.getCapaian()) {
            var capaian = (Capaian)data;
            var container = new AnchorPane();
            container.setPrefWidth(407.0);
            container.setPrefHeight(44.0);
            container.setStyle("-fx-background-radius: 6px; -fx-border-radius: 6px; -fx-border-color: grey; -fx-background-color: white;");
            var boxStatus = new VBox();
            boxStatus.setAlignment(Pos.CENTER_RIGHT);
            boxStatus.setLayoutX(320.0);
            boxStatus.setLayoutY(2.0);
            boxStatus.setPrefWidth(112.0);
            boxStatus.setPrefHeight(39.0);
            if (capaian.isFinish()) {
                var containerFinish = new AnchorPane();
                containerFinish.setPrefHeight(22.0);
                containerFinish.setPrefWidth(123.0);
                containerFinish.setStyle("-fx-background-color: #ffa500; -fx-background-radius: 10px;");
                var label = new Label("Challange Selesai");
                label.setLayoutX(11.0);
                label.setLayoutY(2.0);
                containerFinish.getChildren().add(label);
                boxStatus.getChildren().add(containerFinish);
            } else {
                var percent = (double) capaian.getRemaining() / capaian.getBatasWaktu();
                var progress = new ProgressBar(percent);
                progress.setPrefHeight(18.0);
                progress.setPrefWidth(99.0);
                var label = new Label(capaian.getRemaining() + " hari lagi");
                label.setFont(new Font(10.0));
                boxStatus.getChildren().addAll(progress, label);
            }
            var boxName = new VBox();
            boxName.setAlignment(Pos.CENTER_LEFT);
            boxName.setLayoutX(9.0);
            boxName.setLayoutY(2.0);
            boxName.setPrefHeight(39.0);
            boxName.setPrefWidth(291.0);
            var text = new Text(capaian.getNamaChallange());
            text.setStrokeType(StrokeType.OUTSIDE);
            text.setStrokeWidth(0.0);
            text.setWrappingWidth(294.29425048828125);
            text.setFont(new Font(16.0));
            boxName.getChildren().add(text);
            container.getChildren().addAll(boxStatus, boxName);
            if (capaian.isFinish()) {
                finishList.getChildren().add(container);
            } else {
                progresslist.getChildren().add(container);
            }
        }
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        App.setRoot("member/profile");
    }
}
