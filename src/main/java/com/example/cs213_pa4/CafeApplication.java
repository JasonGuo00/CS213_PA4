package com.example.cs213_pa4;

import cafeapp.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CafeApplication extends Application {
    private static Stage main_stage;

    /**
     * Initializes stage and default view
     * @param stage to initialize
     */
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

    /**
     * Changes the scene to that of a given file
     * @param file to load from
     */
    public static void changeScene(String file) throws IOException {
        FXMLLoader loader = new FXMLLoader(CafeApplication.class.getResource(file));
        Scene scene = new Scene(loader.load());
        main_stage.setScene(scene);
        main_stage.show();
    }

    /**
     * Main function to start program off from
     */
    public static void main(String[] args) throws IOException {
        launch();
    }
}