package com.donatrack.logistica.domain.model;

import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 

public class Pais {
  private String nombre;
  private String nacionalidad;

  public Pais(String nombrePais, String nacionalidad) {
    this.nombre = nombrePais;
    this.nacionalidad = nacionalidad;
  }
}
