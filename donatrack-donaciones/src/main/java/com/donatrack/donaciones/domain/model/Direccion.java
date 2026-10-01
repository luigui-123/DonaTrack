package com.donatrack.donaciones.domain.model;

import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter

public class Direccion{
    private String calle;
    private int altura;
    private Localidad localidad;

public Direccion (String calle, int altura, Localidad localidad) {
    if (calle == null || calle.isBlank() || altura <= 0 || localidad == null) throw new IllegalArgumentException("Direccion invalida"); 
    this.calle= calle;
    this.altura = altura;
    this.localidad = localidad;
}
    
}
