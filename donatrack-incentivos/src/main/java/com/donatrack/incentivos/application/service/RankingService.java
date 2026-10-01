package com.donatrack.incentivos.application.service;

import java.time.Month;
import com.donatrack.incentivos.application.port.out.repository.RankingRepository;
import com.donatrack.incentivos.domain.model.Ranking;
import com.donatrack.incentivos.domain.service.RankearPorMisiones;

public class RankingService {
    private RankingRepository rankingRepository;
    private SeccionIncentivosService seccionIncentivosService;
    public RankingService(RankingRepository rankingRepository){
        this.rankingRepository=rankingRepository;
    }
    public Ranking obtenerRankingMensual(Month mes){
        return this.rankingRepository.buscarPorMes(mes);
    }
    
    public void geneararRankingMensual(){
        RankearPorMisiones rankearPorMisiones = new RankearPorMisiones();
        Ranking ranking = rankearPorMisiones.rankear(this.seccionIncentivosService.obtenerTodos());
        this.rankingRepository.guardar(ranking);
    }
    
}
