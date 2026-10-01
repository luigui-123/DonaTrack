package com.donatrack.incentivos.application.port.out.repository;

import java.util.List;
import java.util.UUID;

import com.donatrack.incentivos.domain.model.Mision;

public interface MisionRepository {
    public void guardar(Mision mision);

    public void crear(Mision mision);

    public Mision buscarPorID(UUID id);

    public List<Mision> obtenerTodos();
}
