package org.example.examenpractico2di;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.example.Models.Libro;

public class ControllerNewPrestamo {

    @FXML
    private Button buttonNewBook;

    @FXML
    private Button buttonNewPrestamo;

    @FXML
    private ListView<Libro> listaLibros;

    @FXML
    void abrirVistaNewBook(ActionEvent event) {

    }

    @FXML
    void abrirVistaNewPrestamo(ActionEvent event) {

    }

    public void initialize(){
        listaLibros.getItems().add(new Libro("1","El Quijote","1234567890"));
        listaLibros.getItems().add(new Libro("2","El Señor de los Anillos","1234567890"));
        listaLibros.getItems().add(new Libro("3","El Principito","1234567890"));
        listaLibros.refresh();
    }

}
