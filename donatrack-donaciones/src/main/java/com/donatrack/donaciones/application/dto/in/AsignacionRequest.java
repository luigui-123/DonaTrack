package com.donatrack.donaciones.application.dto.in;

import com.donatrack.donaciones.application.dto.out.DonacionSegmentadaDTO;
import com.donatrack.donaciones.domain.model.Beneficiaria;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class AsignacionRequest {
    private DonacionSegmentadaDTO donacionSegmentadaDTO;
    private Beneficiaria beneficiaria;
}
