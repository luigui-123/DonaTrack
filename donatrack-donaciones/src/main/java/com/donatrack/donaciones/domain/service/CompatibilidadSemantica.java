package com.donatrack.donaciones.domain.service;

import com.donatrack.donaciones.domain.model.Beneficiaria;
import com.donatrack.donaciones.domain.model.DonacionSegmentada;

import java.util.List;
import java.util.stream.Collectors;

public class CompatibilidadSemantica implements AlgoritmoRecomendador {
    @Override 
    public List<Beneficiaria> recomendarBeneficiarias(DonacionSegmentada donacion, List<Beneficiaria> beneficiarias) {
        AnalizarCompatibilidadDonacionBeneficiaria analizarCompatibilidadDonacionBeneficiaria= new AnalizarCompatibilidadDonacionBeneficiaria();
        return beneficiarias.stream()
            .filter(b -> analizarCompatibilidadDonacionBeneficiaria.analizar(donacion, b) > 0.5)
            .collect(Collectors.toList());
    }
}