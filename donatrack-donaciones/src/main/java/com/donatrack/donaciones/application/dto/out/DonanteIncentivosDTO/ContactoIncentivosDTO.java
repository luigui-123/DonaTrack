package com.donatrack.donaciones.application.dto.out.DonanteIncentivosDTO;

import com.donatrack.donaciones.domain.model.Contacto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter


public class ContactoIncentivosDTO {
    private String email;
    private String telefono;
    public ContactoIncentivosDTO(Contacto contacto){
        this.email = contacto.getCorreoElectronico();
        this.telefono = contacto.getTelefono();

    }
}
