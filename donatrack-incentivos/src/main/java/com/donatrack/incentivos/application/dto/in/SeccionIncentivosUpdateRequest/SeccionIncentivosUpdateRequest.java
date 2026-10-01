package com.donatrack.incentivos.application.dto.in.SeccionIncentivosUpdateRequest;

import java.util.UUID;

import com.donatrack.incentivos.domain.model.DonacionRecibida;

import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class SeccionIncentivosUpdateRequest {
    private UUID id_donante; 
    private DonanteUpdateRequest donanteUpdateRequest; // datos personales actualizados
    private DonacionEntregadaDTO donacionEntregada; //donacion segementada entregada
    private DonacionRecibida donacionNueva; //donacion nueva recibida
}
