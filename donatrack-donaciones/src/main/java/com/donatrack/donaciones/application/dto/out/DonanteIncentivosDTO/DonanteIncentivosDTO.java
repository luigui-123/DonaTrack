package com.donatrack.donaciones.application.dto.out.DonanteIncentivosDTO;

import java.util.UUID;
import com.donatrack.donaciones.domain.model.Donante;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class DonanteIncentivosDTO {
    private UUID id_donante;
    private String nombre;
    private ContactoIncentivosDTO contacto; 
    private DocumentoIncentivosDTO documento;
    public DonanteIncentivosDTO(Donante donante){
        this.id_donante = donante.getIdPersona();
        this.nombre = donante.getNombre();
        this.contacto=new ContactoIncentivosDTO(donante.getContacto());
        this.documento = new DocumentoIncentivosDTO(donante.getDocumentoIdentidad()); 

    }
}
