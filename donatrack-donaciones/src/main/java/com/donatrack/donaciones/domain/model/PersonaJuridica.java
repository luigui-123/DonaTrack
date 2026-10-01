package com.donatrack.donaciones.domain.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 

public class PersonaJuridica extends TipoPersona {
    private String razonSocial;
    private EstructuraSocial estructuraSocial;
    private Rubro rubro;
    private List<Persona> personasRepresentantes;
    private String tipoSociedad;
   
    public PersonaJuridica(String razonSocial, EstructuraSocial estructuraSocial, Rubro rubro) {
        this.razonSocial = razonSocial;
        this.estructuraSocial = estructuraSocial;
        this.rubro = rubro;
        this.personasRepresentantes = new ArrayList<>();
    }
    @Override 
    public String getNombre() 
    { 
        return razonSocial; 
    }
    @Override 
    public Boolean validarTipoPersona()
    { 
        return true; 
    }
    @Override 
    public void setNombreCompleto(String nombre){ //sirve para separar csv
        this.razonSocial = nombre;
        String [] partes =nombre.split(" ");
        this.tipoSociedad = partes[partes.length-1];
    }
    
    public void agregarRepresentante(Persona representante) { personasRepresentantes.add(representante); }
}