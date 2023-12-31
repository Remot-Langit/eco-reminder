package com.remot.langit.ecoreminder.controller;

import com.remot.langit.ecoreminder.App;
import com.remot.langit.ecoreminder.model.Edukasi;
import com.remot.langit.ecoreminder.utils.UserDAO;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EducationController implements Initializable {
    public Text penyusun;
    public Text materi;
    public Text judul;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var edukasi = (Edukasi) App.data.getListEdukasi().get(App.data.getCurrentIndexEdukasi());
        materi.setText(edukasi.getMateri());
        judul.setText(edukasi.getJudul());
        penyusun.setText(String.format("oleh : %s", App.data.getUsernamePenyusun(edukasi.getIdPenyusun())));
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        App.setRoot("member/education list");
    }

    public void prev(MouseEvent mouseEvent) throws IOException {
        var idx = App.data.getCurrentIndexEdukasi();
        if (idx <= 0) {
            App.data.setCurrentIndexEdukasi(App.data.getListEdukasi().size() - 1);
        } else {
            App.data.setCurrentIndexEdukasi(idx - 1);
        }
        App.setRoot("member/education");
    }

    public void next(MouseEvent mouseEvent) throws IOException {
        var idx = App.data.getCurrentIndexEdukasi();
        if (idx >= App.data.getListEdukasi().size() - 1) {
            App.data.setCurrentIndexEdukasi(0);
        } else {
            App.data.setCurrentIndexEdukasi(idx + 1);
        }
        App.setRoot("member/education");
    }
}
