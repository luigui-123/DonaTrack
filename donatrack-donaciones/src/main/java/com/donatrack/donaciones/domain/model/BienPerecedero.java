package com.donatrack.donaciones.domain.model;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BienPerecedero extends Bien {
    private final LocalDate fechaVencimiento;
    
    public BienPerecedero(String nombre, String descripcion, Subcategoria subcategoria, double cantidad,String unidadDeMedida, LocalDate fechaVencimiento) {
        super(nombre, descripcion, subcategoria, cantidad, unidadDeMedida);
        if (fechaVencimiento == null) throw new IllegalArgumentException("La fecha de vencimiento es obligatoria");
        this.fechaVencimiento = fechaVencimiento;
    }
    
    @Override 
    public String obtenerSegmento(){
        return "algo";
    }
    @Override 
    public boolean esAptaParaConsumir(){
        return LocalDate.now().isBefore(fechaVencimiento);

    }
    @Override 
    public Boolean estaVencida(){
        return this.fechaVencimiento.isBefore(LocalDate.now());
    }
}
