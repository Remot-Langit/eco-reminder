package com.remot.langit.ecoreminder.controller;

import com.remot.langit.ecoreminder.App;
import com.remot.langit.ecoreminder.model.Challange;
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

public class ChallangeAdminController implements Initializable {
    public TextArea deskripsi;
    public ChoiceBox<String> batas_waktu;
    public TableView<Challange> table;
    public TextField nama;
    public Label name;
    public ChoiceBox<Integer> point;
    private static Challange challange = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        App.data.refreshChallange();
        App.setTitle("Challange!!");
        this.getListController();
        name.setText(String.format("%s!", App.data.getUser().getNama()));
        batas_waktu.getItems().addAll("1 hari", "2 hari", "3 hari", "4 hari", "5 hari", "6 hari", "7 hari");
        batas_waktu.getSelectionModel().select(0);
        point.getItems().addAll(10, 25, 50, 75, 100, 150, 200);
        point.getSelectionModel().select(0);
    }

    public void getListController() {
        ObservableList<Challange> tableObservable = FXCollections.observableArrayList();
        table.setItems(tableObservable);
        tableObservable.clear();
        tableObservable.addAll(App.data.getListChallange());
        TableColumn<Challange, String> judulColumn = new TableColumn<>("Nama Challange");
        judulColumn.setPrefWidth(210.0);
        judulColumn.setResizable(false);
        judulColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
        TableColumn<Challange, String> batasColumn = new TableColumn<>("Batas Waktu");
        batasColumn.setPrefWidth(90.0);
        batasColumn.setResizable(false);
        batasColumn.setCellValueFactory(challangeStringCellDataFeatures -> {
            var hari = challangeStringCellDataFeatures.getValue().getJumlahHari();
            return new ObservableValue<>() {
                @Override
                public void addListener(ChangeListener<? super String> changeListener) {

                }

                @Override
                public void removeListener(ChangeListener<? super String> changeListener) {

                }

                @Override
                public String getValue() {
                    return String.format("%d hari", hari);
                }

                @Override
                public void addListener(InvalidationListener invalidationListener) {

                }

                @Override
                public void removeListener(InvalidationListener invalidationListener) {

                }
            };
        });
        TableColumn<Challange, HBox> actionColumn = new TableColumn<>("Aksi");
        actionColumn.setPrefWidth(105.0);
        actionColumn.setResizable(false);
        actionColumn.setCellValueFactory(challangeHBoxCellDataFeatures -> {
            var chal = challangeHBoxCellDataFeatures.getValue();
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
                    editButton.setOnMouseClicked(mouseEvent -> edit(chal));
                    var deleteButton = new Button("hapus");
                    deleteButton.setOnMouseClicked(mouseEvent -> delete(chal));
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
        table.getColumns().addAll(judulColumn, batasColumn, actionColumn);
    }

    private void delete(Challange chal) {
        var alert = new Alert(Alert.AlertType.CONFIRMATION, "Apakah anda yakin???");
        var res = alert.showAndWait();
        if (res.isPresent() && res.get().getText().equals("OK")) {
            App.data.deleteChallange(chal);
            try {
                App.setRoot("admin/challange");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void edit(Challange chal) {
        challange = chal;
        nama.setText(challange.getNama());
        deskripsi.setText(challange.getDeskripsi());
        var waktu = challange.getJumlahHari() >= 5 ? 4 : challange.getJumlahHari() - 1;
        batas_waktu.getSelectionModel().select(waktu);
        var po = challange.getPoint();
        var indexPoint = 0;
        // 10, 25, 50, 75, 100, 150, 200
        if (po >= 25)
            indexPoint++;
        if (po >= 75)
            indexPoint++;
        if (po >= 100)
            indexPoint++;
        if (po >= 150)
            indexPoint++;
        if (po >= 200)
            indexPoint++;
        point.getSelectionModel().select(indexPoint);
    }

    public void toHome(MouseEvent mouseEvent) throws IOException {
        App.setRoot("admin/home");
    }

    public void toEducation(MouseEvent mouseEvent) throws IOException {
        App.setRoot("admin/education");
    }

    public void toChallange(MouseEvent mouseEvent) {
    }

    public void submit(MouseEvent mouseEvent) throws IOException {
        if (challange == null)
            App.data.addChallange(nama, deskripsi, batas_waktu, point);
        else
            App.data.editChallange(challange, nama, deskripsi, batas_waktu, point);
        App.setRoot("admin/challange");
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        App.data.logout();
        App.setRoot("laman login");
    }
}
