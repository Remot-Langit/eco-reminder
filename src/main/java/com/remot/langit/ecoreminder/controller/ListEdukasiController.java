package com.remot.langit.ecoreminder.controller;

import com.remot.langit.ecoreminder.App;
import com.remot.langit.ecoreminder.model.Edukasi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListEdukasiController implements Initializable {

    public TableView<Edukasi> table;
    public static ObservableList<Edukasi> tableObservable = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        App.data.refreshEdukasi();
        App.setTitle("List Edukasi");
        this.getEducationTable();
    }

    public void getEducationTable() {
        table.setItems(tableObservable);
        tableObservable.clear();
        tableObservable.addAll(App.data.getListEdukasi());
        TableColumn<Edukasi, String> judulColumn = new TableColumn<>("Judul");
        judulColumn.setPrefWidth(250.0);
        judulColumn.setResizable(false);
        judulColumn.setCellValueFactory(new PropertyValueFactory<>("judul"));
        TableColumn<Edukasi, String> cuplikanColumn = new TableColumn<>("Cuplikan");
        cuplikanColumn.setCellValueFactory(new PropertyValueFactory<>("cuplikan"));
        cuplikanColumn.setPrefWidth(290.0);
        cuplikanColumn.setResizable(false);
        table.getColumns().addAll(judulColumn, cuplikanColumn);
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        App.setRoot("member/profile");
    }

    public void clickItem(MouseEvent event) throws IOException {
        var selectedIndex = table.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < App.data.getListEdukasi().size()) {
            App.data.setCurrentIndexEdukasi(table.getSelectionModel().getSelectedIndex());
            App.setRoot("member/education");
        }
    }
}
