package com.donatrack.incentivos.application.dto.in.SeccionIncentivosUpdateRequest;

import com.donatrack.incentivos.domain.model.Contacto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class DonanteUpdateRequest {
    private String nombre;
    private Contacto contacto;

}
