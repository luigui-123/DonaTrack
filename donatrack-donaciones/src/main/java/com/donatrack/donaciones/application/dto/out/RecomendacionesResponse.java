package com.donatrack.donaciones.application.dto.out;

import java.util.List;

import com.donatrack.donaciones.domain.model.Beneficiaria;

public class RecomendacionesResponse {
    DonacionSegmentadaDTO donacionSegmentadaDTO;
    List<Beneficiaria> beneficiarias;
    public RecomendacionesResponse (DonacionSegmentadaDTO donacionSegmentadaDTO, List<Beneficiaria> beneficiarias){
        this.beneficiarias=beneficiarias;
        this.donacionSegmentadaDTO = donacionSegmentadaDTO;
    }
}
