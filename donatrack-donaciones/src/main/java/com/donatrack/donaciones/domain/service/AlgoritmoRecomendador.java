package com.donatrack.donaciones.domain.service;

import com.donatrack.donaciones.domain.model.Beneficiaria;
import com.donatrack.donaciones.domain.model.DonacionSegmentada;

import java.util.List;

public interface AlgoritmoRecomendador {
    List<Beneficiaria> recomendarBeneficiarias(DonacionSegmentada donacion, List<Beneficiaria> beneficiarias);
}