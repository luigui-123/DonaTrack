package com.donatrack.incentivos.domain.model;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class SubCategoria {
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    public SubCategoria(String nombre,String descripcion,Categoria categoria){
        this.nombre= nombre;
        this.descripcion=descripcion;
        this.categoria=categoria;
    }
    
}
