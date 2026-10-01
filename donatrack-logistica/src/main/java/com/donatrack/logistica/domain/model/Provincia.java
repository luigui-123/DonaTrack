package com.donatrack.logistica.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class Provincia {
  private String nombre;
  private Pais pais;

  public Provincia(String nombreProvincia, Pais pais) {
    this.nombre = nombreProvincia;
    this.pais = pais;
  }
}
