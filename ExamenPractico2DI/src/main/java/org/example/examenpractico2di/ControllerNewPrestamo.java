package org.example.examenpractico2di;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.Models.Libro;

public class ControllerNewPrestamo {

    @FXML
    private Button buttonCancelar;

    @FXML
    private Button buttonNewPrestmo;

    @FXML
    private TextField textIdLibro;

    @FXML
    private TextField textIdUsuario;

    private ControllerPrincipal controllerPrincipal=new ControllerPrincipal();

    @FXML
    void cancelarVista(ActionEvent event) {

        textIdLibro.clear();
        textIdUsuario.clear();
        //cerra ventana
        this.buttonCancelar.getScene().getWindow().hide();
    }

    @FXML
    void confirmarPrestamo(ActionEvent event) {
        if (textIdLibro.getText().isEmpty() || textIdUsuario.getText().isEmpty()) {
            System.out.println("Faltan datos");
        } else {
            //Aqui vamos a devolver los datos al controlador main que es el que se encargara de dar de alta el libro
            controllerPrincipal.biblioteca.prestar(textIdLibro.getText(),textIdUsuario.getText());
            //cerra ventana
            this.buttonCancelar.getScene().getWindow().hide();
        }
    }

}
