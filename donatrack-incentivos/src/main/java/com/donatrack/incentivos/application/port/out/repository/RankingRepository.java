package com.donatrack.incentivos.application.port.out.repository;

import java.time.Month;

import com.donatrack.incentivos.domain.model.Ranking;

public interface RankingRepository {

    Ranking buscarPorMes(Month mes);

    void guardar(Ranking ranking);
    
}
