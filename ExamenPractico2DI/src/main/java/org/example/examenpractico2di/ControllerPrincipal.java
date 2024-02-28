package org.example.examenpractico2di;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.example.Models.Biblioteca;
import org.example.Models.Libro;

import java.io.IOException;

/**
 * JavaFX App
 */
public class ControllerPrincipal {

    @FXML
    private Button buttonNewBook;

    @FXML
    private Button buttonNewPrestamo;

    @FXML
    private ListView<Libro> listaLibros;

    public Biblioteca biblioteca;

    /**
     * Metodo que se ejecuta al pulsar el boton de alta de libro
     * @param event
     */
    @FXML
    void abrirVistaNewBook(ActionEvent event) {
        //Aqui vamos a abrir la ventana de alta de libro
        try {
            // Load the FXML file for the new window
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vistaNewLibro.fxml"));
            // Create a new scene
            Scene scene = new Scene(fxmlLoader.load());
            // Create a new stage
            Stage stage = new Stage();
            // Set the scene to the stage
            stage.setScene(scene);
            // Add a listener to the onHidden property of the stage
            stage.setOnHidden(e -> updateBookList());
            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Metodo que se ejecuta al pulsar el boton de alta de prestamo
     * @param
     */
    private void updateBookList() {
        // Clear the current list
        listaLibros.getItems().clear();
        // Add all books from the biblioteca to the list
        listaLibros.getItems().addAll(biblioteca.getLibros());
        // Refresh the list view
        listaLibros.refresh();
    }

    /**
     * Metodo que se ejecuta al pulsar el boton de alta de prestamo
     * @param event
     */
    @FXML
    void abrirVistaNewPrestamo(ActionEvent event) {

    }

    /**
     * Metodo que se ejecuta al inicializar la ventana
     */
    public void initialize(){
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.altaLibro(new Libro("1","El Quijote","1234567890"));
        biblioteca.altaLibro(new Libro("2","El Señor de los Anillos","1234567890"));
        biblioteca.altaLibro(new Libro("3","El Principito","1234567890"));
        listaLibros.getItems().addAll(biblioteca.getLibros());
        listaLibros.refresh();
    }

}
