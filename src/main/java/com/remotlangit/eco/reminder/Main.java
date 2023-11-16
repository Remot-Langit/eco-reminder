/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.remotlangit.eco.reminder;

import com.remotlangit.eco.reminder.model.Admin;
import com.remotlangit.eco.reminder.model.User;

/**
 *
 * @author WIN 10
 */
public class Main {
    public static void main(String[] args) {
        User us1 = new User("user1", "useran", "user@upi.edu", "pass", "0880238208", "https://google.com");
        Admin admin = new Admin("admin", "adminan", "admin@upi.edu", "123", "1028392", "https://facebook.com");

        admin.sendNotification("Bahaya buang sampah sembarangan", "sampah adalah sebuah benda yang .......");
        admin.addChallange("Membuang sampah ke tempatnya", "Pengguna membuang sampah pada tempat yang memang untuk membuang sampah", 30, 1000);
        us1.addEdukasi("Bahaya buang sampah sembarangan", "lorem ipsum dolor amet sit color di consecterum bala bala", "https://example.com");
        
    }
    
}
