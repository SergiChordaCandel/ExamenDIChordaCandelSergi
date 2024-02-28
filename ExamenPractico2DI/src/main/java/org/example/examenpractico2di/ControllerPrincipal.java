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
import org.example.Models.Usuario;

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

    public ControllerPrincipal(){
        biblioteca = new Biblioteca();
    }

    /**
     * Metodo que se ejecuta al pulsar el boton de alta de libro
     * @param event
     */
    @FXML
    void abrirVistaNewBook(ActionEvent event) {
        //Aqui vamos a abrir la ventana de alta de libro
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vistaNewLibro.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setOnHidden(e -> updateBookList());
            stage.show();

            ControllerNewLibro controller = fxmlLoader.getController();
            controller.setControllerPrincipal(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Metodo que se ejecuta al pulsar el boton de alta de prestamo
     * @param
     */
    private void updateBookList() {
        System.out.println("Updating book list");
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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vistaNewPrestamo.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            ControllerNewPrestamo controller = fxmlLoader.getController();
            controller.setControllerPrincipal(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que se ejecuta al inicializar la ventana
     */
    public void initialize(){
        biblioteca.altaLibro(new Libro("1","El Quijote","1234567890"));
        biblioteca.altaLibro(new Libro("2","El Señor de los Anillos","1234567890"));
        biblioteca.altaLibro(new Libro("3","El Principito","1234567890"));
        biblioteca.altaUsuario(new Usuario("123456789Z"));
        biblioteca.altaUsuario(new Usuario("123456789Y"));
        biblioteca.altaUsuario(new Usuario("123456789X"));
        listaLibros.getItems().addAll(biblioteca.getLibros());
        listaLibros.refresh();
    }

}
