package com.example.cs213_pa4;

import cafeapp.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CafeApplication extends Application {
    private static Stage main_stage;
    @Override
    public void start(Stage stage) throws IOException {
        main_stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(CafeApplication.class.getResource("cafeapp-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("porject4!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void changeScene(String file) throws IOException {
        FXMLLoader loader = new FXMLLoader(CafeApplication.class.getResource(file));
        Scene scene = new Scene(loader.load());
        main_stage.setScene(scene);
        main_stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();
    }
}