module com.remot.langit.ecoreminder {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.base;
    requires java.sql;
    requires io.github.cdimascio.dotenv.java;

    opens com.remot.langit.ecoreminder to javafx.fxml;
    exports com.remot.langit.ecoreminder;
    exports com.remot.langit.ecoreminder.model;
    exports com.remot.langit.ecoreminder.controller;
    opens com.remot.langit.ecoreminder.controller to javafx.fxml;
}