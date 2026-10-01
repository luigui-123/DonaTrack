package com.donatrack.donaciones.domain.model;

public record Provincia(String nombre, Pais pais) {
    public Provincia { if (nombre == null || nombre.isBlank() || pais == null) throw new IllegalArgumentException("Provincia invalida"); }
}