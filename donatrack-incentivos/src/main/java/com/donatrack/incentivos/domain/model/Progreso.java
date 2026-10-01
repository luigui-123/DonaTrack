package com.donatrack.incentivos.domain.model;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class Progreso {
    private Integer cantidadBeneficiariasAyudadas;
    private Integer cantidadBienesDonados;
    private LocalDate fecha;
    private List<Categoria> categorias;
    public Progreso(Integer cantidadBeneficiariasAyudadas,Integer cantidadBienesDonados,List<Categoria>categorias){
        
        this.cantidadBeneficiariasAyudadas = cantidadBeneficiariasAyudadas;
        this.cantidadBienesDonados = cantidadBienesDonados;
        this.fecha = LocalDate.now();
        this.categorias = categorias;
    }
    
    
}
