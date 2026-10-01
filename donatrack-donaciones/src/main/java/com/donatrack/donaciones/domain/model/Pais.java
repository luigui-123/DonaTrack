package com.donatrack.donaciones.domain.model;

public record Pais(String nombre) {
    public Pais { if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Pais invalido"); }
}