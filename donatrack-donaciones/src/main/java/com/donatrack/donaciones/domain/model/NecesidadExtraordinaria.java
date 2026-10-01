package com.donatrack.donaciones.domain.model;

import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 

public class NecesidadExtraordinaria extends Necesidad {
    private int tiempoEsperadoRespuesta;
    public NecesidadExtraordinaria(String descripcion,List<NecesidadParcial>necesidadesParciales, int tiempoEsperadoRespuesta) { 
        super(descripcion, necesidadesParciales); 
        this.tiempoEsperadoRespuesta = tiempoEsperadoRespuesta;
    }
    @Override 
    public boolean estaCubierta(LocalDate fecha){ 
        return true; 
    }
}