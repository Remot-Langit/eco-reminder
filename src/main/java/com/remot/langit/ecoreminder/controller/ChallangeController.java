package com.remot.langit.ecoreminder.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.remot.langit.ecoreminder.App;
import com.remot.langit.ecoreminder.model.UserMember;
import com.remot.langit.ecoreminder.utils.CapaianDAO;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ChallangeController implements Initializable {

    public Text deskripsi;
    public Text batasWaktu;
    public Text point;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        var challange = App.data.getCurrentChallange();
        App.setTitle(challange.getNama());
        deskripsi.setText(challange.getDeskripsi());
        batasWaktu.setText(String.format("%d hari", challange.getJumlahHari()));
        point.setText(String.format("%d poin", challange.getPoint()));
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        App.setRoot("member/challange list");
    }


    public void start(MouseEvent mouseEvent) throws IOException {
        var alert = new Alert(Alert.AlertType.CONFIRMATION, "Mulai?");
        var res = alert.showAndWait();
        if (res.isPresent() && res.get().getText().equals("OK")) {
            var dao = new CapaianDAO();
            dao.insert((UserMember) App.data.getUser(), App.data.getCurrentChallange());
            App.setRoot("member/capaian");
        }
    }
}

