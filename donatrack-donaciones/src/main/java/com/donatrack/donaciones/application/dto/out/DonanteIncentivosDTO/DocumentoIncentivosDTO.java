package com.donatrack.donaciones.application.dto.out.DonanteIncentivosDTO;

import com.donatrack.donaciones.domain.model.DocumentoIdentidad;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class DocumentoIncentivosDTO {
    private String numero;
    private String tipo;
    public DocumentoIncentivosDTO(DocumentoIdentidad documentoIdentidad){
        this.numero=documentoIdentidad.getNumero();
        this.tipo=documentoIdentidad.getTipoDocumento().toString();
    }
}
