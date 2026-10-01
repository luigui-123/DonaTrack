package com.donatrack.incentivos.domain.model;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class HabilDonador extends Mision{
    public HabilDonador(String descripcion,Integer objetivo,Insignia insignia){
        super("Racha",descripcion,objetivo,insignia);
    }
    @Override 
    public void evaluarMision(Progreso progreso) {
        Integer cantidadBienes = progreso.getCantidadBienesDonados();
        Integer objetivo = this.getObjetivo();
        this.setObjetivo(objetivo-cantidadBienes);
        if(this.getObjetivo()<0){
            setEstaCompletado(true);
            setFechaFin(LocalDate.now());
        }        
    }
    @Override 
     public void verificarYActualizarRacha(){}
}
