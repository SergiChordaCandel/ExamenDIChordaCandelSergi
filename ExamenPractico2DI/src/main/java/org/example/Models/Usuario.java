package org.example.Models;

import java.util.Date;

public class Usuario {
    private String dniUsuario;
    private Date fechaAltaSancion;

    public Usuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public void Sancionar() {
        //la sancion desaparecera dentro de 10 dias
        fechaAltaSancion = new Date();
        fechaAltaSancion.setDate(fechaAltaSancion.getDate() + 10);

    }

    public void Desancionar() {
        //Aqui le quitamos la sancion
        fechaAltaSancion = null;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public Date getFechaAltaSancion() {
        return fechaAltaSancion;
    }

    public void setFechaAltaSancion(Date fechaAltaSancion) {
        this.fechaAltaSancion = fechaAltaSancion;
    }
}
