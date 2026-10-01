package com.donatrack.incentivos.application.dto.in.SeccionIncentivosUpdateRequest;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 

public class DonacionEntregadaDTO {
    private UUID id_donacionRecibida;
    private UUID id_donacionSegmentada;
}
