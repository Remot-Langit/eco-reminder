package com.remot.langit.ecoreminder;

import com.remot.langit.ecoreminder.utils.Data;
import com.remot.langit.ecoreminder.model.User;
import com.remot.langit.ecoreminder.utils.CapaianDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App<T extends User> extends Application {
    private static Scene scene;
    private static Stage stage;
    public static CapaianDAO dao = new CapaianDAO();
    public static Data data = new Data();

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        scene = new Scene(loadFXML("welcome"));
        setTitle();
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public static void setTitle(String title) {
        stage.setTitle(title);
    }

    public static void setTitle() {
        stage.setTitle("Eco Reminder!!!");
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}