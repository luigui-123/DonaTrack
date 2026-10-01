package com.donatrack.incentivos.domain.model;
import java.time.LocalDate;

import org.springframework.cglib.core.Local;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public abstract class Mision {
    private String nombre;
    private String descripcion;
    private Integer objetivo;
    private Insignia insignia;
    private Boolean estaCompletado;
    private String nivel;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    public Mision(String nombre,String descripcion,Integer objetivo,Insignia insignia){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.objetivo=objetivo;
        this.insignia=insignia;
        this.estaCompletado = false;
    }
    public void setFechaInicio(){
        this.fechaInicio = LocalDate.now();
    }
    public abstract void evaluarMision(Progreso progreso);
     public abstract void verificarYActualizarRacha();
}
