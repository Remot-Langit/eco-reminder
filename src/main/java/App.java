/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Acer
 */
public class App extends Application {
    
    @Override
    public void start(Stage stage)throws IOException {
        
        URL url = new File ("src/main/java/view/Login.fxml").toURI() .toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
}