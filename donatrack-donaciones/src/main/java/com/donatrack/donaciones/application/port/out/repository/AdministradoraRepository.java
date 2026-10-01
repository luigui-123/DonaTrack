package com.donatrack.donaciones.application.port.out.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.donatrack.donaciones.domain.model.Administradora;

public interface AdministradoraRepository {
	Administradora findById(UUID id);
	void save(Administradora administradora);
	List<Administradora> findAll();
}
