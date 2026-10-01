package com.donatrack.donaciones.domain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.donatrack.donaciones.domain.service.ProcesadorCargaInicial;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter 

public class DonacionOriginal {

    private final UUID idDonacionOriginal;
    private final LocalDate fecha;
    private final String descripcion;
    private final Donante donante;
    private final Administradora administradora;
    private final List<DonacionSegmentada> donacionesSegmentadas;
   
    public DonacionOriginal( String descripcion, Donante donante, Administradora administradora,List<Bien> bienes) {
        if (donante == null || administradora == null) 
            throw new IllegalArgumentException("Donacion invalida");
        this.idDonacionOriginal = UUID.randomUUID(); 
        this.fecha = LocalDate.now(); 
        this.descripcion = descripcion; 
        this.donante = donante; 
        this.administradora = administradora;
        this.donacionesSegmentadas = generarDonacionesSegmentadas(bienes);
        }
    
    public List<DonacionSegmentada> generarDonacionesSegmentadas(List<Bien> bienes) { 
        ProcesadorCargaInicial procesador = new ProcesadorCargaInicial();
        return procesador.procesar(bienes).stream().map(segmento -> new DonacionSegmentada(segmento, this.donante)).toList();
    }
}