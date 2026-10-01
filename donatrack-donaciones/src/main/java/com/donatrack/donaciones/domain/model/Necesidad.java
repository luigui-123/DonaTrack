package com.donatrack.donaciones.domain.model;

import java.time.LocalDate;
import java.util.List;
import lombok.Setter;
import lombok.Getter;
@Getter 
@Setter 

public abstract class Necesidad {
    private final LocalDate fechaSolicitud;
    private final String descripcion;
    private final List<NecesidadParcial> necesidadesParciales;
    private EstadoNecesidad estadoNecesidad;

    protected Necesidad(String descripcion,List<NecesidadParcial> necesidadesParciales) {

        this.descripcion = descripcion; 
        this.fechaSolicitud = LocalDate.now();
        this.necesidadesParciales = necesidadesParciales;
        this.estadoNecesidad = EstadoNecesidad.NO_CUBIERTA;
    }
    
    public void registrarDonacion(NecesidadParcial necesidadParcial) {
        necesidadesParciales.add(necesidadParcial);
    }
    public abstract boolean estaCubierta(LocalDate fecha);
}