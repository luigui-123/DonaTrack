package com.donatrack.donaciones.domain.model;
import java.util.Objects;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public abstract class Persona {
    private UUID idPersona;
    private Direccion direccion;
    private Contacto contacto;
    private DocumentoIdentidad documentoIdentidad;
    private TipoPersona tipoPersona;

    public Persona(Direccion direccion, Contacto contacto,TipoPersona tipoPersona,DocumentoIdentidad documentoIdentidad) {
        this.idPersona = UUID.randomUUID();
        this.direccion = Objects.requireNonNull(direccion);
        this.contacto = Objects.requireNonNull(contacto);
        this.tipoPersona = tipoPersona;
        this.documentoIdentidad = documentoIdentidad;
    }
    
    public String getNombre(){
        return tipoPersona.getNombre(); 
    }
    public void setNombre(String nombre){
        this.tipoPersona.setNombreCompleto(nombre);
    }
    public void actulizarInformacion(String nombre,String email,String telefono){
        this.contacto.setCorreoElectronico(email);
        this.contacto.setTelefono(telefono);
        this.setNombre(nombre);
    }
}