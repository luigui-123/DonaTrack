package com.donatrack.incentivos.domain.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class Categoria {
    private String nombre;
    private String descripcion;
    private List<SubCategoria> subCategorias;
    public Categoria(String nombre,String descripcion,List<SubCategoria> subCategorias){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.subCategorias=subCategorias;
    }
    
}
