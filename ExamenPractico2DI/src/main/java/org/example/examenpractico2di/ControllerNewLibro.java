package org.example.examenpractico2di;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.Models.Libro;

/**
 * JavaFX App
 */
public class ControllerNewLibro {

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonConfirmar;

    @FXML
    private TextField textID;

    @FXML
    private TextField textISBN;

    @FXML
    private TextField textTitulo;

    private ControllerPrincipal controllerPrincipal=new ControllerPrincipal();

    /**
     * Metodo que se ejecuta al pulsar el boton de cancelar
     * @param event
     */
    @FXML
    void cancelar(ActionEvent event) {
        textID.clear();
        textTitulo.clear();
        textISBN.clear();
        //cerra ventana
        this.buttonCancel.getScene().getWindow().hide();

    }

    /**
     * Metodo que se ejecuta al pulsar el boton de confirmar
     * @param event
     */
    @FXML
    void confirmar(ActionEvent event) {
        if (textID.getText().isEmpty() || textTitulo.getText().isEmpty() || textISBN.getText().isEmpty()) {
            System.out.println("Faltan datos");
        }else {
            //Aqui vamos a devolver los datos al controlador main que es el que se encargara de dar de alta el libro
            controllerPrincipal.biblioteca.altaLibro(new Libro(textID.getText(),textTitulo.getText(),textISBN.getText()));
            //cerra ventana
            this.buttonConfirmar.getScene().getWindow().hide();
        }
    }
}
