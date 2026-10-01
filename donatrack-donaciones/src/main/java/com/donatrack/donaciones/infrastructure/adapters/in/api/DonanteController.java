package com.donatrack.donaciones.infrastructure.adapters.in.api;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.donatrack.donaciones.application.dto.in.FiltrosDonacionDTO;
import com.donatrack.donaciones.application.dto.out.DonacionSegmentadaDTO;
import com.donatrack.donaciones.application.service.DonacionOriginalService;
import com.donatrack.donaciones.application.service.DonacionSegmentadaService;
import com.donatrack.donaciones.application.service.DonanteService;
import com.donatrack.donaciones.domain.model.Contacto;
import com.donatrack.donaciones.domain.model.Direccion;
import com.donatrack.donaciones.domain.model.Donante;

@RestController
@RequestMapping("/donantes")
public class DonanteController {

	private final DonanteService donanteService;
	private final DonacionSegmentadaService donacionSegmentadaService;
	
	public DonanteController(DonanteService donanteService,DonacionSegmentadaService donacionSegmentadaService) {
		this.donanteService = donanteService;
		this.donacionSegmentadaService = donacionSegmentadaService;
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Donante donante) {
		donanteService.create(donante);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<Donante>> getAll() {
		return ResponseEntity.ok(donanteService.getAll());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") UUID id, @RequestBody UpdateRequest request) {
		donanteService.update(id, request.direccion(), request.contacto());
		return ResponseEntity.ok().build();
	}

	public record UpdateRequest(Contacto contacto, Direccion direccion) {
	}

	@GetMapping ("/{id}/donaciones")
	public List<DonacionSegmentadaDTO> filtrarDonacionesRealizadas(@PathVariable ("id")UUID id ,@RequestParam FiltrosDonacionDTO filtro){
		return donacionSegmentadaService.filtraDoancionesPorFiltros(id,filtro);
	}
}
