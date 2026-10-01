package com.donatrack.donaciones.domain.model;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 

public abstract class Bien {
    private final UUID idBien = UUID.randomUUID(); 
    private final String nombre; 
    private final String descripcion;
    private final Subcategoria subcategoria; 
    private final double cantidad; 
    private final String unidadDeMedida;
    
    public Bien(String nombre, String descripcion, Subcategoria subcategoria, double cantidad, String unidadDeMedida) {
        if (nombre == null || nombre.isBlank() || subcategoria == null || cantidad <= 0) throw new IllegalArgumentException("Bien invalido");
        this.nombre = nombre; 
        this.descripcion = descripcion; 
        this.subcategoria = subcategoria; 
        this.cantidad = cantidad; 
        this.unidadDeMedida = unidadDeMedida;
    }

    public abstract String obtenerSegmento();
    public abstract boolean esAptaParaConsumir();
    public abstract Boolean estaVencida();
}