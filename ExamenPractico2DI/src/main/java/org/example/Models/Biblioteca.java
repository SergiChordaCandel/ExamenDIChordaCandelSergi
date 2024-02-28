package org.example.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Prestamo> prestamos = new ArrayList<>();

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
        }
    }

    public void bajaLibro(String id) {
        //Aqui eliminamos un libro de la lista de libros
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId().equals(id)) {
                libros.remove(i);
            }
        }
    }

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
        }
    }

    public void bajaUsuario(String dni) {
        //Aqui eliminamos un usuario de la lista de usuarios
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getDniUsuario().equals(dni)) {
                usuarios.remove(i);
            }
        }
    }

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
        }

    }

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
            }
        }

    }

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

    public List<Libro> getLibros() {
        return libros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}
