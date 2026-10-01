package com.donatrack.logistica.domain.model;

public class Ubicacion {
    private String calle;
    private String altura;
    private Localidad localidad;
    public Ubicacion(String calle,String altura,Localidad localidad){
        this.calle=calle;
        this.altura=altura;
        this.localidad=localidad;
    }
}
