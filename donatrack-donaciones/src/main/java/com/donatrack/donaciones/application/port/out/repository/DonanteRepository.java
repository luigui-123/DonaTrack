package com.donatrack.donaciones.application.port.out.repository;

import java.util.List;
import java.util.UUID;

import com.donatrack.donaciones.domain.model.DocumentoIdentidad;
import com.donatrack.donaciones.domain.model.DonacionSegmentada;
import com.donatrack.donaciones.domain.model.Donante;

public interface DonanteRepository {
	Donante findById(UUID id);
	Donante buscarPorDocumento(DocumentoIdentidad documentoIdentidad);
	void save(Donante donante);
	List<Donante> findAll();
	List<DonacionSegmentada> findDonaciones(UUID id);
	
    
}
