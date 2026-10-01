package com.donatrack.donaciones.domain.model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter 

public class Subcategoria {
    private final String nombre; 
    private final String descripcion; 
    private final Categoria categoria;

    public Subcategoria(String nombre, String descripcion, Categoria categoria) { 
        if (nombre == null || nombre.isBlank() || categoria == null) throw new IllegalArgumentException("Subcategoria invalida"); 
        this.nombre = nombre; 
        this.descripcion = descripcion; 
        this.categoria = categoria; 
    }
    public boolean esSubcategoriaDe(Categoria categoria) { return this.categoria.equals(categoria); }
}