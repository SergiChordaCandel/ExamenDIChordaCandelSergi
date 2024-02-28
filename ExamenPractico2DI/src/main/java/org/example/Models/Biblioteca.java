package org.example.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class represents a Biblioteca (Library) with its books, users and loans.
 * It provides methods to manage books, users and loans such as adding, removing, lending and returning books.
 */
public class Biblioteca {
    private List<Libro> libros ;
    private List<Usuario> usuarios ;
    private List<Prestamo> prestamos ;



    /**
     * Constructs a new Biblioteca with empty lists of books, users and loans.
     */
    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    /**
     * Adds a new book to the library if it's not already present.
     * @param libro The book to be added.
     */
    public void altaLibro(Libro libro) {
        //Aqui añadimos un libro a la lista de libros y gestionaremos que el libro no se repita
        boolean repetido = false;
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId().equals(libro.getId())) {
                repetido = true;
            }
        }
        if (!repetido) {
            libros.add(libro);
            System.out.println("Libro añadido");
        }
    }

    /**
     * Removes a book from the library.
     * @param id The id of the book to be removed.
     */
    public void bajaLibro(String id) {
        //Aqui eliminamos un libro de la lista de libros
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId().equals(id)) {
                libros.remove(i);
                System.out.println("Libro eliminado");
            }
        }
    }

    /**
     * Adds a new user to the library if they're not already present.
     * @param usuario The user to be added.
     */
    public void altaUsuario(Usuario usuario) {
        //Aqui añadimos un usuario a la lista de usuarios y gestionaremos que el usuario no se repita
        boolean repetido = false;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getDniUsuario().equals(usuario.getDniUsuario())) {
                repetido = true;
            }
        }
        if (!repetido) {
            usuarios.add(usuario);
            System.out.println("Usuario añadido");
        }
    }

    /**
     * Removes a user from the library.
     * @param dni The dni of the user to be removed.
     */
    public void bajaUsuario(String dni) {
        //Aqui eliminamos un usuario de la lista de usuarios
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getDniUsuario().equals(dni)) {
                usuarios.remove(i);
                System.out.println("Usuario eliminado");
            }
        }
    }

    /**
     * Lends a book to a user if the user and the book exist and the user is not sanctioned.
     * @param idLibro The id of the book to be lent.
     * @param dniUsuario The dni of the user to lend the book to.
     */
    public void prestar(String idLibro, String dniUsuario) {
        //Aqui le ponemos la fecha de devolucion que serán 14 dias y
        //gestionamos que sol opuedan coger un libro si el usuario existe ,
        // no tienen sancion y si el libro existe

        Date fechaDevolucion = new Date();
        fechaDevolucion.setDate(fechaDevolucion.getDate() + 14);
        boolean existeUsuario = false;
        boolean existeLibro = false;
        boolean sancionado = false;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getDniUsuario().equals(dniUsuario)) {
                existeUsuario = true;
                if (usuarios.get(i).getFechaAltaSancion() != null) {
                    sancionado = true;
                }
            }
        }
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId().equals(idLibro)) {
                existeLibro = true;
            }
        }
        if (existeUsuario && existeLibro && !sancionado) {
            Prestamo prestamo = new Prestamo(idLibro, dniUsuario);
            prestamos.add(prestamo);
            System.out.println("Prestamo añadido");
        }

    }

    /**
     * Returns a book from a user. If the book is returned late, the user is sanctioned.
     * @param idLibro The id of the book to be returned.
     * @param dniUsuario The dni of the user returning the book.
     */
    public void devolver(String idLibro, String dniUsuario) {
        //Aqui le quitamos la fecha de devolucion y gestionamos si el usuario
        // ha devuelto a tiempo o no y se le aplicara una sancion si no lo ha hecho
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getIdLibro().equals(idLibro) && prestamos.get(i).getDniUsuario().equals(dniUsuario)) {
                Date fechaActual = new Date();
                if (prestamos.get(i).getFechaDevolucion()!=null && fechaActual.after(prestamos.get(i).getFechaDevolucion())) {
                    for (int j = 0; j < usuarios.size(); j++) {
                        if (usuarios.get(j).getDniUsuario().equals(dniUsuario)) {
                            usuarios.get(j).Sancionar();
                        }
                    }
                }
                prestamos.remove(i);
                System.out.println("Prestamo eliminado");
            }
        }

    }

    /**
     * Returns a book from a user for testing purposes. If the book is returned late, the user is sanctioned.
     * @param idLibro The id of the book to be returned.
     * @param dniUsuario The dni of the user returning the book.
     */
    public void devolverTardeParaProvarTest(String idLibro, String dniUsuario) {
        //Aqui le quitamos la fecha de devolucion y gestionamos si el usuario
        // ha devuelto a tiempo o no y se le aplicara una sancion si no lo ha hecho
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getIdLibro().equals(idLibro) && prestamos.get(i).getDniUsuario().equals(dniUsuario)) {
                Date fechaTarde = new Date();
                fechaTarde.setDate(fechaTarde.getDate() + 15);
                if (prestamos.get(i).getFechaDevolucion()!=null && fechaTarde.after(prestamos.get(i).getFechaDevolucion())) {
                    for (int j = 0; j < usuarios.size(); j++) {
                        if (usuarios.get(j).getDniUsuario().equals(dniUsuario)) {
                            usuarios.get(j).Sancionar();
                        }
                    }
                }
                prestamos.remove(i);
            }
        }

    }

    /**
     * Returns the list of books in the library.
     * @return The list of books.
     */
    public List<Libro> getLibros() {
        return libros;
    }

    /**
     * Returns the list of users in the library.
     * @return The list of users.
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Returns the list of loans in the library.
     * @return The list of loans.
     */
    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}
