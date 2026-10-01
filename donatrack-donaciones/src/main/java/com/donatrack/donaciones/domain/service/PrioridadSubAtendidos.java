package com.donatrack.donaciones.domain.service;

import com.donatrack.donaciones.domain.model.Beneficiaria;
import com.donatrack.donaciones.domain.model.DonacionSegmentada;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrioridadSubAtendidos implements AlgoritmoRecomendador {
    @Override 
    public List<Beneficiaria> recomendarBeneficiarias(DonacionSegmentada donacion, List<Beneficiaria> beneficiarias) {
        return beneficiarias.stream().sorted(Comparator.comparingInt(b -> b.getNecesidades().size())).limit(10).collect(Collectors.toList());
    }
}