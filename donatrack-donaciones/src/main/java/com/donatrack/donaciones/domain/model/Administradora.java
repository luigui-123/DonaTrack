package com.donatrack.donaciones.domain.model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class Administradora extends Persona {
    private String rol;
    public Administradora( Direccion direccion, Contacto contacto,TipoPersona tipoPersona,DocumentoIdentidad documentoIdentidad) {
        super(direccion, contacto,tipoPersona, documentoIdentidad);
        this.rol= "admnistradora";
        
    }
}