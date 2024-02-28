package org.example.Models;

import java.util.Date;

/**
 * Clase que representa un usuario
 */
public class Usuario {
    private String dniUsuario;
    private Date fechaAltaSancion;

    /**
     * Constructor de la clase usuario
     * @param dniUsuario
     */
    public Usuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    /**
     * Metodo que sanciona a un usuario
     */
    public void Sancionar() {
        //la sancion desaparecera dentro de 10 dias
        fechaAltaSancion = new Date();
        fechaAltaSancion.setDate(fechaAltaSancion.getDate() + 10);

    }

    /**
     * Metodo que desanciona a un usuario
     */
    public void Desancionar() {
        //Aqui le quitamos la sancion
        fechaAltaSancion = null;
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
    public Date getFechaAltaSancion() {
        return fechaAltaSancion;
    }

    /**
     *
     * @param fechaAltaSancion
     */
    public void setFechaAltaSancion(Date fechaAltaSancion) {
        this.fechaAltaSancion = fechaAltaSancion;
    }
}
