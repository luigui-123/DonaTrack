package com.donatrack.donaciones.application.dto.in;

import java.util.List;
import java.util.UUID;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;

import com.donatrack.donaciones.domain.model.Bien;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 

public class RecepcionRequest {
    private UUID id_donante;
    private UUID id_administradora;
    private List<Bien> bienes;
    private String descripcion;
    public RecepcionRequest (UUID id_donante, UUID id_administradora, List<Bien> bienes, String descripcion){
        this.id_donante=id_donante;
        this.id_administradora=id_administradora;
        this.bienes = bienes;
        this.descripcion=descripcion;
    }
    
}
