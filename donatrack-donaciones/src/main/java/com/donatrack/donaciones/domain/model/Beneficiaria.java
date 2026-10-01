package com.donatrack.donaciones.domain.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 


public class Beneficiaria extends Persona {

    private List<Necesidad> necesidades;
    private List<DonacionSegmentada> donacionSegmentadas;

    protected Beneficiaria(Direccion direccion, Contacto contacto, TipoPersona tipoPersona,DocumentoIdentidad documentoIdentidad) {
        super(direccion, contacto, tipoPersona,documentoIdentidad);
        this.donacionSegmentadas = new ArrayList<>();
    }
    public void agregarNecesidad(Necesidad necesidad){
        this.necesidades.add(necesidad);
    }


}
