package com.donatrack.incentivos.application.port.out.client;

import com.donatrack.incentivos.application.dto.out.AscensoMisionEvent;

public interface NotificacionesClient {
    public void enviarAscensoMisionEvent(AscensoMisionEvent ascensoMisionEvent);
    
}
