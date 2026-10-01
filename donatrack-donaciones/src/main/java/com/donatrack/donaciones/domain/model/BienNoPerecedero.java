package com.donatrack.donaciones.domain.model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class BienNoPerecedero extends Bien {
    private Boolean estaUsado;
    private Boolean esFragil;
    private Boolean estaRoto;
    public BienNoPerecedero(String nombre, String descripcion, Subcategoria subcategoria, double cantidad, String unidadDeMedida,Boolean estaUsado, Boolean esFragil, Boolean estaRoto) {
        super(nombre, descripcion, subcategoria, cantidad, unidadDeMedida);
        this.estaUsado = estaUsado;
        this.esFragil = esFragil;
        this.estaRoto = estaRoto;
    }
    @Override
    public String obtenerSegmento() {
        return estaUsado ? "Usado" : "No usado";
    }
    @Override
    public boolean esAptaParaConsumir() {
        return !estaRoto;
    }
    @Override 
    public Boolean estaVencida(){
        return false;
    }

    
}
