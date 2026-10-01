package com.donatrack.donaciones.application.dto.in;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter

public class CSVrequest {
    private String tipoPersona;
    private String tipoDocumento;
    private String documento;
    private String nombre;
    private String email;
    private String telefono;
    
}
