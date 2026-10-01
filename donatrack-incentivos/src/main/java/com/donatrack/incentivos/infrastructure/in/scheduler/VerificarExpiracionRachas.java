package com.donatrack.incentivos.infrastructure.in.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.donatrack.incentivos.application.service.SeccionIncentivosService;

@Component 

public class VerificarExpiracionRachas {
    private SeccionIncentivosService seccionIncentivosService;
    public VerificarExpiracionRachas(SeccionIncentivosService seccionIncentivosService){
        this.seccionIncentivosService=seccionIncentivosService;
    }
    @Scheduled (cron = "0 0 0 * * ?")
    public void verificar(){
        this.seccionIncentivosService.verificarExpiracionRachas();
    }

    
}
