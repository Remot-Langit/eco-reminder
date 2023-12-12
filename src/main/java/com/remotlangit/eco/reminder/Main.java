/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.remotlangit.eco.reminder;

import com.remotlangit.eco.reminder.model.Admin;
import com.remotlangit.eco.reminder.model.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author WIN 10
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage)throws IOException {
        
        URL url = new File ("src/main/java/com/remotlangit/eco/reminder/view/challange.fxml").toURI() .toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
//    public static void main(String[] args) {
//        User us1 = new User("user1", "useran", "user@upi.edu", "pass", "0880238208", "https://google.com");
//        Admin admin = new Admin("admin", "adminan", "admin@upi.edu", "123", "1028392", "https://facebook.com");
//
//        admin.sendNotification("Bahaya buang sampah sembarangan", "sampah adalah sebuah benda yang .......");
//        admin.addChallange("Membuang sampah ke tempatnya", "Pengguna membuang sampah pada tempat yang memang untuk membuang sampah", 30, 1000);
//        us1.addEdukasi("Bahaya buang sampah sembarangan", "lorem ipsum dolor amet sit color di consecterum bala bala", "https://example.com");
//        App.launch(args);
//    }
    
}
