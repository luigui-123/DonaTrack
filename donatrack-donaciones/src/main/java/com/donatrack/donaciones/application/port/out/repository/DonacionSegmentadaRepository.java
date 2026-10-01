package com.donatrack.donaciones.application.port.out.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.donatrack.donaciones.domain.model.DonacionSegmentada;

public interface DonacionSegmentadaRepository {
	DonacionSegmentada findById(UUID id);
	void save(DonacionSegmentada donacion);
	List<DonacionSegmentada> findAll();
	List<DonacionSegmentada> findByIdDonante(UUID id);
	List<DonacionSegmentada> buscarPorBeneficiaria(UUID id_beneficiaria);

}
