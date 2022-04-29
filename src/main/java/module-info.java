module com.example.chessgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.chessgame to javafx.fxml;
    exports com.example.chessgame;
    exports com.example.chessgame.controller;
    opens com.example.chessgame.controller to javafx.fxml;
}
