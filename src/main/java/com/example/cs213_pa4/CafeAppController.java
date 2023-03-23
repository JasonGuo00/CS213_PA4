package com.example.cs213_pa4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class CafeAppController {
    @FXML
    private Button donut;
    @FXML
    private Button coffee;
    @FXML
    private Button basket;
    @FXML
    private Button shoplist;

    @FXML
    void changeSceneCoffee() throws IOException {
        CafeApplication.changeScene("coffee-view.fxml");
    }
    @FXML
    void changeSceneDonut() throws IOException {
        CafeApplication.changeScene("donut-view.fxml");
    }

    @FXML
    void changeSceneOrder() throws IOException {
        CafeApplication.changeScene("order-view.fxml");
    }

}