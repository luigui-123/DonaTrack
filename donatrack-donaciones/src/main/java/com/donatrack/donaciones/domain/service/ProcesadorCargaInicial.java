package com.donatrack.donaciones.domain.service;

import com.donatrack.donaciones.domain.model.Bien;
import java.util.ArrayList;
import java.util.List;

public class ProcesadorCargaInicial {
    public List<List<Bien>> procesar(List<Bien> bienes)
    {
        List<List<Bien>> bienesSegmentados = new ArrayList<>();

        PorSegmento porSegmento = new PorSegmento();
        
        PorSubcategoria porSubcategoria = new PorSubcategoria();
        
        List<List<Bien>> subcategorias = porSubcategoria.segmentar(bienes);
        
        for (List<Bien> subcategoria : subcategorias) {
            List<List<Bien>> segmentos = porSegmento.segmentar(subcategoria);
            for (List<Bien> segmento : segmentos) {
                bienesSegmentados.add(segmento);
            }
        }
        return bienesSegmentados;
    }
}