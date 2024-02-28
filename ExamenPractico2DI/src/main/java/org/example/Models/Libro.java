package org.example.Models;

import java.util.Date;

public class Libro {
    private String id;
    private String titulo;
    private String isbn;
    private String autor;
    private Tematica tematica;
    private Date FechaDeEdicion;

    public Libro(String id, String titulo, String isbn, String autor, Tematica tematica, Date FechaDeEdicion) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.tematica = tematica;
        this.FechaDeEdicion = FechaDeEdicion;
    }

    public Libro(String id,String titulo,String isbn){
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAutor() {
        return autor;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public Date getFechaDeEdicion() {
        return FechaDeEdicion;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }

    public void setFechaDeEdicion(Date fechaDeEdicion) {
        FechaDeEdicion = fechaDeEdicion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
