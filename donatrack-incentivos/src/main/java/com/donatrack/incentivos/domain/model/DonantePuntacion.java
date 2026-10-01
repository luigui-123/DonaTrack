package com.donatrack.incentivos.domain.model;

public class DonantePuntacion {
    private String nombreDonante;
    private Long puntacion; 
    public DonantePuntacion(String nombreDonante,Long puntuacion){
        this.nombreDonante=nombreDonante;
        this.puntacion=puntuacion;
    }
    
}
