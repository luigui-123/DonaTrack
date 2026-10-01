package com.donatrack.incentivos.application.port.out.repository;

import com.donatrack.incentivos.domain.model.DonanteIncentivos;

public interface DonanteIncentivosRepository {
    public void guardar(DonanteIncentivos donanteIncentivos);
}
