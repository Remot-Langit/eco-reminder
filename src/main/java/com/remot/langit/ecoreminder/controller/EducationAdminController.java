package com.remot.langit.ecoreminder.controller;

import com.remot.langit.ecoreminder.App;
import com.remot.langit.ecoreminder.model.Edukasi;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EducationAdminController implements Initializable {
    public TextArea materi;
    public TextField referensi;
    public TableView<Edukasi> table;
    public TextField judul;
    public Label name;
    private static Edukasi edu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        App.data.refreshEdukasi();
        table.getColumns().clear();
        this.getEducationTable();
        App.setTitle("Edukasi");
        name.setText(String.format("%s!", App.data.getUser().getNama()));
    }

    public void getEducationTable() {
        ObservableList<Edukasi> tableObservable = FXCollections.observableArrayList();
        table.setItems(tableObservable);
        tableObservable.clear();
        tableObservable.addAll(App.data.getListEdukasi());
        TableColumn<Edukasi, String> judulColumn = new TableColumn<>("Judul");
        judulColumn.setPrefWidth(230.0);
        judulColumn.setResizable(false);
        judulColumn.setCellValueFactory(new PropertyValueFactory<>("judul"));
        TableColumn<Edukasi, String> penyusunColumn = new TableColumn<>("Penyusun");
        penyusunColumn.setPrefWidth(80.0);
        penyusunColumn.setResizable(false);
        penyusunColumn.setCellValueFactory(edukasiStringCellDataFeatures -> {
            var idPenyusun = edukasiStringCellDataFeatures.getValue().getIdPenyusun();
            return new ObservableValue<>() {
                @Override
                public void addListener(ChangeListener<? super String> changeListener) {

                }

                @Override
                public void removeListener(ChangeListener<? super String> changeListener) {

                }

                @Override
                public String getValue() {
                    return App.data.getUsernamePenyusun(idPenyusun);
                }

                @Override
                public void addListener(InvalidationListener invalidationListener) {

                }

                @Override
                public void removeListener(InvalidationListener invalidationListener) {

                }
            };
        });

        TableColumn<Edukasi, HBox> actionColumn = new TableColumn<>("Aksi");
        actionColumn.setPrefWidth(105.0);
        actionColumn.setResizable(false);
        actionColumn.setCellValueFactory(challangeHBoxCellDataFeatures -> {
            var edukasi = challangeHBoxCellDataFeatures.getValue();
            return new ObservableValue<>() {
                @Override
                public void addListener(ChangeListener<? super HBox> changeListener) {

                }

                @Override
                public void removeListener(ChangeListener<? super HBox> changeListener) {

                }

                @Override
                public HBox getValue() {
                    var box = new HBox();
                    box.setAlignment(Pos.CENTER);
                    box.setSpacing(3.0);
                    var editButton = new Button("edit");
                    editButton.setOnMouseClicked(mouseEvent -> edit(edukasi));
                    var deleteButton = new Button("hapus");
                    deleteButton.setOnMouseClicked(mouseEvent -> delete(edukasi));
                    box.getChildren().addAll(editButton, deleteButton);
                    return box;
                }

                @Override
                public void addListener(InvalidationListener invalidationListener) {

                }

                @Override
                public void removeListener(InvalidationListener invalidationListener) {

                }
            };
        });

        table.getColumns().addAll(judulColumn, penyusunColumn, actionColumn);

    }

    private void edit(Edukasi edukasi) {
        edu = edukasi;
        judul.setText(edu.getJudul());
        materi.setText(edu.getMateri());
        referensi.setText(edu.getReferensi());
    }
    public void submit(MouseEvent mouseEvent) throws IOException {
        if (edu == null)
            App.data.addEdukasi(judul, materi, referensi);
        else
            App.data.editEducation(edu, judul, materi, referensi);
        App.setRoot("admin/education");
    }
    private void delete(Edukasi edukasi) {
        var alert = new Alert(Alert.AlertType.CONFIRMATION, "Apakah anda yakin???");
        var res = alert.showAndWait();
        if (res.isPresent() && res.get().getText().equals("OK")) {
            App.data.deleteEducation(edukasi);
            try {
                App.setRoot("admin/education");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void toHome(MouseEvent mouseEvent) throws IOException {
        App.setRoot("admin/home");
    }

    public void toEducation(MouseEvent mouseEvent) {
    }

    public void toChallange(MouseEvent mouseEvent) throws IOException {
        App.setRoot("admin/challange");
    }



    public void logout(MouseEvent mouseEvent) throws IOException {
        App.data.logout();
        App.setRoot("laman login");
    }
}
