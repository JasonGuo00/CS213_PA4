package com.example.cs213_pa4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CafeAppController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}