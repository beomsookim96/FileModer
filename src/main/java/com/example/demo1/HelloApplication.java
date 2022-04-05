package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage.setMaxWidth(240);
        stage.setMinWidth(240);
        stage.getIcons().add(new Image("file:src/main/resources/com/example/demo1/icon/logo-dark.png"));
        Scene scene = new Scene(fxmlLoader.load(), 240, 800);
        stage.setTitle("JSONModer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}