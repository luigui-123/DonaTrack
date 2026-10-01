package com.donatrack.incentivos.domain.model;

import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class DonacionSegmentada {
    private UUID id_donacionSegmentada;   
    private List<Bien> bienes;
    private Boolean estaEntregada;
    
    public Integer cantidadBienes(){
        return bienes.size();
    }
    public Categoria getCategoria(){
        return this.bienes.get(0).getSubCategoria().getCategoria();
    }
}
