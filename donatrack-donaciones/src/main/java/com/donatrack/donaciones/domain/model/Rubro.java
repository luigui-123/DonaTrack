package com.donatrack.donaciones.domain.model;

public record Rubro(String nombre) {
    public Rubro { if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Rubro invalido"); }
}