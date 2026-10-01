package com.donatrack.donaciones.domain.model;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class PersonaHumana extends TipoPersona {
    private String nombre;
    private String apellido;
    private Genero genero;
    private Integer edad;
    public PersonaHumana(String nombre, String apellido, Genero genero, Integer edad){
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.genero = genero; 
        this.edad = edad;    
    }
    
    @Override 
    public String getNombre() { 
        return nombre + " " + apellido; 
    }
    @Override 
    public Boolean validarTipoPersona() { 
        return true;
    }
    @Override 
    public void setNombreCompleto(String nombre) {
        
        String [] partes  = nombre.split(" ");
        this.nombre= partes[0];
        this.apellido = partes[1];
    }
    
}