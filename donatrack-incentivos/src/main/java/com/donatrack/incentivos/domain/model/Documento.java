package com.donatrack.incentivos.domain.model;

import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class Documento {
    private String numero;
    private String tipo;
    public Documento(String numero,String tipo){
        this.numero=numero;
        this.tipo=tipo;
    }
}
