package com.donatrack.donaciones.domain.model;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class DocumentoIdentidad {
    private TipoDocumento tipoDocumento;
    private String numero;
    public DocumentoIdentidad(TipoDocumento tipo, String numero) {
        if (tipo == null || numero == null || numero.isBlank()) throw new IllegalArgumentException("Documento invalido");
        this.tipoDocumento=tipo;
        this.numero=numero;
    }
}
