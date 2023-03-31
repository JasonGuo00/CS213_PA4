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

    /**
     * Changes scene to the coffee view
     */
    @FXML
    void changeSceneCoffee() throws IOException {
        CafeApplication.changeScene("coffee-view.fxml");
    }

    /**
     * Changes scene to the donut view
     */
    @FXML
    void changeSceneDonut() throws IOException {
        CafeApplication.changeScene("donut-view.fxml");
    }

    /**
     * Changes scene to the order view
     */
    @FXML
    void changeSceneOrder() throws IOException {
        CafeApplication.changeScene("order-view.fxml");
    }

    /**
     * Changes scene to the store view
     */
    @FXML
    void changeSceneStore() throws IOException {
        CafeApplication.changeScene("store-view.fxml");
    }

}