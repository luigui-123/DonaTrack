package com.donatrack.donaciones.domain.model;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 

public class NecesidadParcial {
    private Bien bien;
    private int cantidad;
    public NecesidadParcial(Bien bien, int cantidad) {
        if (bien == null || cantidad <= 0) throw new IllegalArgumentException("Necesidad parcial invalida");
        this.bien = bien;
        this.cantidad = cantidad;
    }

}
