package com.donatrack.donaciones.application.port.out.client;

import com.donatrack.donaciones.application.dto.out.DonacionSegmentadaDTO;
import com.donatrack.donaciones.application.dto.out.DonanteIncentivosDTO.DonanteIncentivosDTO;

public interface IncentivosClient {

    public void enviarDonante(DonanteIncentivosDTO donanteIncentivosDTO);
}