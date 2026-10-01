package com.donatrack.incentivos.domain.service;

import java.util.List;

import com.donatrack.incentivos.domain.model.Ranking;
import com.donatrack.incentivos.domain.model.SeccionIncentivos;

public interface RankearStrategy {
    public Ranking rankear(List<SeccionIncentivos> perfiles);
}
