package com.donatrack.donaciones.infrastructure.adapters.in.api;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donatrack.donaciones.application.dto.out.DonacionSegmentadaDTO;
import com.donatrack.donaciones.application.service.BeneficiariaService;
import com.donatrack.donaciones.domain.model.Beneficiaria;
import com.donatrack.donaciones.domain.model.Contacto;
import com.donatrack.donaciones.domain.model.Direccion;
import com.donatrack.donaciones.domain.model.Necesidad;

@RestController
@RequestMapping("/beneficiarias")
public class BeneficiariaController {

	private final BeneficiariaService beneficiariaService;

	public BeneficiariaController(BeneficiariaService beneficiariaService) {
		this.beneficiariaService = beneficiariaService;
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Beneficiaria beneficiaria) {
		beneficiariaService.create(beneficiaria);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<Beneficiaria>> getAll() {
		return ResponseEntity.ok(beneficiariaService.getAll());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") UUID id, @RequestBody UpdateRequest request) {
		beneficiariaService.update(id, request.contacto(), request.direccion());
		return ResponseEntity.ok().build();
	}

	public record UpdateRequest(Contacto contacto, Direccion direccion) {
	}
	@PatchMapping ("/{id}/necesidades")
	public ResponseEntity <Void> agregarNecesidad(@PathVariable ("id") UUID id ,Necesidad necesidad){
		beneficiariaService.registrarNecesidad(id,necesidad);
		return ResponseEntity.ok().build();
	}
	@GetMapping ("/{id}/donaciones/asignadas")
	public ResponseEntity<List<DonacionSegmentadaDTO>> obtenerDonacionesAsignadad(@PathVariable ("id") UUID id) {
		return ResponseEntity.ok(beneficiariaService.obtenerDonacionesAsignadas(id));
	}
	
}
