package org.example.Models;

import java.util.Date;

public class Prestamo {
    private String idLibro;
    private String dniUsuario;

    private Date fechaDevolucion;

    public Prestamo(String idLibro, String dniUsuario) {
        //Cuando creamos un prestamo ponemos la fecha de devolucion que serán 14 dias
        Date fechaDevolucion = new Date();
        fechaDevolucion.setDate(fechaDevolucion.getDate() + 14);
        this.idLibro = idLibro;
        this.dniUsuario = dniUsuario;
        this.fechaDevolucion=fechaDevolucion;
    }

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
