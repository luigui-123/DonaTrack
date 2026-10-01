package com.donatrack.donaciones.application.port.out.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.donatrack.donaciones.domain.model.Beneficiaria;
import com.donatrack.donaciones.domain.model.Necesidad;

public interface BeneficiariaRepository {
	Beneficiaria findById(UUID id);
	void save(Beneficiaria beneficiaria);
	List<Beneficiaria> findAll();
	void guardarNecesidad(Necesidad necesidad);
	
}
