package com.donatrack.donaciones.application.dto.out;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter

public class DonanteDTO {
    private UUID idPersona;    
    private LocalDate ultimaFechaActivo;
    private String rol;
    
}
