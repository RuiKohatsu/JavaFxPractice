package com.example.javafxpractice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StoneGameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StoneGameApplication.class.getResource("stonegame-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        //StoneGameController stone = new StoneGameController();
        //stone.initialize();
        stage.setTitle("石取りゲーム");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}