package com.donatrack.donaciones.domain.model;

public abstract class TipoPersona {
    public abstract String getNombre();
    public abstract Boolean validarTipoPersona();
    protected abstract void setNombreCompleto(String nombre);
}