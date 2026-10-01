package com.donatrack.incentivos.domain.model;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class DonacionesExitosas extends Mision {
    
    public DonacionesExitosas(String descripcion,Integer objetivo,Insignia insignia){
        super("Racha",descripcion,objetivo,insignia);
    }
    @Override 
    public void evaluarMision(Progreso progreso) {
        Integer cantidadBeneficiarias = progreso.getCantidadBeneficiariasAyudadas();
        Integer objetivo = this.getObjetivo();
        this.setObjetivo(objetivo-cantidadBeneficiarias);
        if(this.getObjetivo()<0){
            this.setEstaCompletado(true);
        }
                
    }
    @Override 
     public void verificarYActualizarRacha(){}
}
