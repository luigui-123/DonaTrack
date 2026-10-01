package com.donatrack.donaciones.domain.service;

import com.donatrack.donaciones.domain.model.Bien;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PorSegmento implements SegmentarStrategy {
    @Override 
    public List<List<Bien>> segmentar(List<Bien> bienes) {
        return bienes.stream().collect(Collectors.groupingBy(Bien::obtenerSegmento)).values().stream().map(ArrayList::new).collect(Collectors.toList());
    }
}