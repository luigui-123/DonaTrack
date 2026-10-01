package com.donatrack.logistica.domain.model;

public class Localidad {
    private String nombre;
    private Provincia provincia;
    public Localidad(String nombre,Provincia provincia){
        this.nombre=nombre;
        this.provincia=provincia;
        
    }
    
}
