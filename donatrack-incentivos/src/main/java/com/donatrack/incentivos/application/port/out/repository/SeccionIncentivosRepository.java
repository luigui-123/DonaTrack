package com.donatrack.incentivos.application.port.out.repository;

import java.util.List;
import java.util.UUID;

import com.donatrack.incentivos.domain.model.SeccionIncentivos;

public interface SeccionIncentivosRepository {
    public void guardar(SeccionIncentivos seccionIncentivos);

    public SeccionIncentivos buscarPorDonante(UUID id_donanteIncentivos);

    public List<SeccionIncentivos> obtenerTodos();
}
