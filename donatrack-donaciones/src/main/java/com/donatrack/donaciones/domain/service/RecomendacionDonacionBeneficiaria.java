package com.donatrack.donaciones.domain.service;

import com.donatrack.donaciones.domain.model.Beneficiaria;
import com.donatrack.donaciones.domain.model.DonacionSegmentada;
import java.util.List;

public class RecomendacionDonacionBeneficiaria {
    
    public List<Beneficiaria> recomendarBeneficiarias(DonacionSegmentada donacion, List<Beneficiaria> beneficiarias) {
        CompatibilidadSemantica compatibilidadSemantica = new CompatibilidadSemantica();
        PrioridadSubAtendidos prioridadSubAtendidos = new PrioridadSubAtendidos();
        List<Beneficiaria>beneficiarias2 = compatibilidadSemantica.recomendarBeneficiarias(donacion, beneficiarias);
        List<Beneficiaria> beneficiarias3 = prioridadSubAtendidos.recomendarBeneficiarias(donacion, beneficiarias2);
        for(Beneficiaria b : beneficiarias3){
            beneficiarias.remove(b);
        }
        return  beneficiarias3;

}
}