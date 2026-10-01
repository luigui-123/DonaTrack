package com.donatrack.donaciones.domain.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
//revidado
public class Categoria {
    private final String nombre; 
    private final String descripcion; 
    private final List<Subcategoria> subcategorias;

    public Categoria(String nombre, String descripcion) { 
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre obligatorio"); 
        this.nombre = nombre; 
        this.descripcion = descripcion; 
        this.subcategorias = new ArrayList<>();
    }
 
    public void agregarSubcategoria(Subcategoria subcategoria) { subcategorias.add(subcategoria); }
}