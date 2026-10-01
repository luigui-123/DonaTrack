package com.donatrack.incentivos.domain.model;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class Racha extends Mision {
    private Integer objetivoInicial;
    private LocalDate ultimaFecha;
    public Racha(String descripcion,Integer objetivo,Insignia insignia){
        super("Racha",descripcion,objetivo,insignia);
        this.objetivoInicial = objetivo;
        this.ultimaFecha=null;
    }
    @Override 
    public void evaluarMision(Progreso progreso) {
        if(ultimaFecha==null)
        {
            this.setObjetivo(objetivoInicial-1);
            this.ultimaFecha = progreso.getFecha();
        }

        if(progreso.getFecha().isAfter(this.ultimaFecha.plusMonths(1))){
            this.volverInicio();
            return;
        }

        this.setObjetivo(objetivoInicial-1);
        this.ultimaFecha = progreso.getFecha();

        if(this.getObjetivo()==0){
            this.setEstaCompletado(true);
            this.setFechaFin(LocalDate.now());
        }

    }
    public void verificarYActualizarRacha() {
        LocalDate fechaActual = LocalDate.now();

        // Calcula la diferencia exacta en meses enteros
        long mesesPasados = ChronoUnit.MONTHS.between(this.ultimaFecha, fechaActual);

        if (mesesPasados >= 1) {
            System.out.println("Pasó un mes o más. ¡Racha reiniciada!");
            this.volverInicio();
            return; 
        }

        
    }
    public void volverInicio(){
        this.setObjetivo(objetivoInicial);
    }
    
}
