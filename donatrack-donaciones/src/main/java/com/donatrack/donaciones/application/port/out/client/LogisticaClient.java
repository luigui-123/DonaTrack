package com.donatrack.donaciones.application.port.out.client;

import com.donatrack.donaciones.application.dto.out.DonacionSegmentadaDTO;

public interface LogisticaClient {
    public void enviarDonacionAsignada(DonacionSegmentadaDTO donacionRequestDTO);
}
