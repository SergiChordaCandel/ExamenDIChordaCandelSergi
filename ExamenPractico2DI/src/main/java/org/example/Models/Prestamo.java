package org.example.Models;

import java.util.Date;

/**
 * Clase que representa un prestamo
 */
public class Prestamo {
    private String idLibro;
    private String dniUsuario;

    private Date fechaDevolucion;

    /**
     * Constructor de la clase prestamo
     * @param idLibro
     * @param dniUsuario
     */
    public Prestamo(String idLibro, String dniUsuario) {
        //Cuando creamos un prestamo ponemos la fecha de devolucion que serán 14 dias
        Date fechaDevolucion = new Date();
        fechaDevolucion.setDate(fechaDevolucion.getDate() + 14);
        this.idLibro = idLibro;
        this.dniUsuario = dniUsuario;
        this.fechaDevolucion=fechaDevolucion;
    }

    /**
     *
     * @return
     */
    public String getIdLibro() {
        return idLibro;
    }

    /**
     *
     * @param idLibro
     */
    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    /**
     *
     * @return
     */
    public String getDniUsuario() {
        return dniUsuario;
    }

    /**
     *
     * @param dniUsuario
     */
    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    /**
     *
     * @return
     */
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     *
     * @param fechaDevolucion
     */
    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
