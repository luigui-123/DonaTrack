package com.donatrack.incentivos.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.donatrack.incentivos.application.dto.in.SeccionIncentivosUpdateRequest.DonanteUpdateRequest;

import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class DonanteIncentivos {
    private UUID id_donante;
    private String nombre;
    private Contacto contacto; 
    private Documento documento;
    public DonanteIncentivos (UUID id_donante,String nombre,Contacto contacto, Documento documento){
        this.id_donante =id_donante;
        this.nombre= nombre;
        this.contacto=contacto;
        this.documento = documento;

    }
    public void actualizarInformacion(DonanteUpdateRequest donanteUpdateRequest) {
        this.nombre=donanteUpdateRequest.getNombre();
        this.contacto = donanteUpdateRequest.getContacto();
    }
    
}
