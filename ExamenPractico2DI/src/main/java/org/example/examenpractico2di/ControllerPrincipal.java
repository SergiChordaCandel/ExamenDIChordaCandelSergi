package org.example.examenpractico2di;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerPrincipal {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

}