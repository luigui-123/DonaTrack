package com.donatrack.donaciones.domain.model;

import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class NecesidadRecurrente extends Necesidad {

    private final TipoPeriodo periodo;

    public NecesidadRecurrente(String descripcion,List<NecesidadParcial> necesidadesParciales, TipoPeriodo periodo) {
        super(descripcion, necesidadesParciales);
        if (periodo == null) throw new IllegalArgumentException("El periodo es obligatorio");
        this.periodo = periodo;
    }
    
    @Override public boolean estaCubierta(LocalDate fecha) { 
        return true; 
    }
}