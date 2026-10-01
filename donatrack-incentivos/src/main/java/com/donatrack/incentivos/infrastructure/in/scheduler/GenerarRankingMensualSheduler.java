package com.donatrack.incentivos.infrastructure.in.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.donatrack.incentivos.application.service.RankingService;
@Component 
public class GenerarRankingMensualSheduler {

    private RankingService rankingService;
    public GenerarRankingMensualSheduler(RankingService rankingService){
        this.rankingService=rankingService;
    }
    // Se ejecuta a las 23:00:00 (11 PM) del último día de cada mes
    @Scheduled(cron = "0 0 23 L * ?")
    public void ejecutarAlFinalDelMes() {
        this.rankingService.geneararRankingMensual();
        System.out.println("Ejecutando tarea automática de fin de mes...");
    }
}
