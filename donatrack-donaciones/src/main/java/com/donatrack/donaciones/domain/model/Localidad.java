package com.donatrack.donaciones.domain.model;

public record Localidad(String nombre, Provincia provincia) {
    public Localidad { if (nombre == null || nombre.isBlank() || provincia == null) throw new IllegalArgumentException("Localidad invalida"); }
}