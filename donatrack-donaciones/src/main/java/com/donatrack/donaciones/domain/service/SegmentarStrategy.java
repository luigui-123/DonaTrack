package com.donatrack.donaciones.domain.service;

import com.donatrack.donaciones.domain.model.Bien;
import java.util.List;

public interface SegmentarStrategy {
    List<List<Bien>> segmentar(List<Bien> bienes);
}