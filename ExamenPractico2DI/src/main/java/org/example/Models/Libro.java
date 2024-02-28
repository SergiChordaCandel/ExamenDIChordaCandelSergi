package org.example.Models;

import java.util.Date;
/**
 * Clase que representa un libro
 */
public class Libro {
    private String id;
    private String titulo;
    private String isbn;
    private String autor;
    private Tematica tematica;
    private Date FechaDeEdicion;

    /**
     *
     * @param id
     * @param titulo
     * @param isbn
     * @param autor
     * @param tematica
     * @param FechaDeEdicion
     */
    public Libro(String id, String titulo, String isbn, String autor, Tematica tematica, Date FechaDeEdicion) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.tematica = tematica;
        this.FechaDeEdicion = FechaDeEdicion;
    }

    /**
     *
     * @param id
     * @param titulo
     * @param isbn
     */
    public Libro(String id,String titulo,String isbn){
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @return
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     *
     * @return
     */
    public String getAutor() {
        return autor;
    }

    /**
     *
     * @return
     */
    public Tematica getTematica() {
        return tematica;
    }

    /**
     *
     * @return
     */
    public Date getFechaDeEdicion() {
        return FechaDeEdicion;
    }

    /**
     *
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     *
     * @param tematica
     */
    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }

    /**
     *
     * @param fechaDeEdicion
     */
    public void setFechaDeEdicion(Date fechaDeEdicion) {
        FechaDeEdicion = fechaDeEdicion;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Devuelve el ToString de la clase
     * @return
     */
    @Override
public String toString() {
    return id + "\t" +
           titulo + "\t" +
           isbn + "\t" +
           autor + "\t" +
           tematica + "\t" +
           FechaDeEdicion;
}
}
