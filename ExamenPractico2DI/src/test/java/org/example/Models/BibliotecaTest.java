package org.example.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {



    @Test
    void altaLibroAtributosNoRepetidos() {
        //Aqui apareceran las pruevas para el alta de un libro
        Biblioteca biblioteca = new Biblioteca();
        Libro libro = new Libro("1", "El Quijote", "Cervantes");
        biblioteca.altaLibro(libro);
        assertEquals(1, biblioteca.getLibros().size());
    }

    @Test
    void altaLibroAtributosRepetidos() {
        //Aqui apareceran las pruevas para el alta de un libro
        Biblioteca biblioteca = new Biblioteca();
        Libro libro = new Libro("1", "El Quijote", "Cervantes");
        biblioteca.altaLibro(libro);
        biblioteca.altaLibro(libro);
        assertEquals(1, biblioteca.getLibros().size());
    }

    @Test
    void devolverDentroDeFecha() {
        //Aqui apareceran las pruevas para devolver un libro dentro de la fecha
        Biblioteca biblioteca = new Biblioteca();
        Libro libro = new Libro("1", "El Quijote", "Cervantes");
        biblioteca.altaLibro(libro);
        Usuario usuario = new Usuario("12345678A");
        biblioteca.altaUsuario(usuario);
        biblioteca.prestar("1", "12345678A");
        biblioteca.devolver(libro.getId(), usuario.getDniUsuario());
        assertEquals(0, biblioteca.getPrestamos().size());

    }

    @Test
    void devolverFueraDeFecha() {
        //Aqui apareceran las pruevas para devolver un libro fuera de la fecha
        Biblioteca biblioteca = new Biblioteca();
        Libro libro = new Libro("1", "El Quijote", "Cervantes");
        biblioteca.altaLibro(libro);
        Usuario usuario = new Usuario("12345678A");
        biblioteca.altaUsuario(usuario);
        biblioteca.prestar("1", "12345678A");
        biblioteca.devolverTardeParaProvarTest(libro.getId(), usuario.getDniUsuario());
        //Se espera que la fecha de la sancion no sea null ya que se le habra aplicado una sancion
        assertNotNull(usuario.getFechaAltaSancion());
    }

    @Test
    void prestarLibroNoExiste() {
        //Aqui apareceran las pruevas para prestar un libro que no existe
        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario = new Usuario("12345678A");
        biblioteca.altaUsuario(usuario);
        biblioteca.prestar("1", "12345678A");
        assertEquals(0, biblioteca.getPrestamos().size());
    }

    @Test
    void prestarUsuarioNoExiste() {
        //Aqui apareceran las pruevas para prestar un libro a un usuario que no existe
        Biblioteca biblioteca = new Biblioteca();
        Libro libro = new Libro("1", "El Quijote", "Cervantes");
        biblioteca.altaLibro(libro);
        biblioteca.prestar("1", "12345678A");
        assertEquals(0, biblioteca.getPrestamos().size());
    }

    @Test
    void prestarTodoExiste() {
        //Aqui apareceran las pruevas para prestar un libro a un usuario que existe y el libro tambien
        Biblioteca biblioteca = new Biblioteca();
        Libro libro = new Libro("1", "El Quijote", "Cervantes");
        biblioteca.altaLibro(libro);
        Usuario usuario = new Usuario("12345678A");
        biblioteca.altaUsuario(usuario);
        biblioteca.prestar("1", "12345678A");
        assertEquals(1, biblioteca.getPrestamos().size());
    }


}