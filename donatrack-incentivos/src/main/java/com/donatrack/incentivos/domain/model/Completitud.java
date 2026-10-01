package com.donatrack.incentivos.domain.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class Completitud extends Mision {
    private List<Categoria> categoriasRegistradas;
    public Completitud(String descripcion,Integer objetivo,Insignia insignia,Mision sgteMision){
        super("Racha",descripcion,objetivo,insignia);
        this.categoriasRegistradas = new ArrayList<>();
        
    }
    @Override 
    public void evaluarMision(Progreso progreso) {
        if(this.categoriasRegistradas.isEmpty()){
            this.categoriasRegistradas.addAll(progreso.getCategorias());
            for (Categoria categoria : progreso.getCategorias()){
                this.setObjetivo(getObjetivo()-1);
            }
        }
        for (Categoria categoria : progreso.getCategorias()){
            if(!this.categoriasRegistradas.contains(categoria)){
                this.setObjetivo(getObjetivo()-1);
            }
        }
        if(this.getObjetivo()==0){
            this.setEstaCompletado(true);
            this.setFechaFin(LocalDate.now());
        }
        
    }
    @Override 
     public void verificarYActualizarRacha(){}
}
