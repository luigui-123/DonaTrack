package com.donatrack.donaciones.domain.model;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 

public class EstadoDonacion {

    private final TipoEstadoDonacion estado;
    private final LocalDate fecha;

    public EstadoDonacion(TipoEstadoDonacion estado) {
        if (estado == null) throw new IllegalArgumentException("Estado de donacion invalido");
        this.estado = estado;
        this.fecha = LocalDate.now();
    }
}
