package com.donatrack.incentivos.domain.model;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class Insignia {
    private String nombre;
    private String descripcion;
    private Boolean esVisible;
    public Insignia(String nombre,String descripcion){
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.esVisible=true;
    }
}
