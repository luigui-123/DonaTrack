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
import org.springframework.web.bind.annotation.RestController;
import com.donatrack.donaciones.application.dto.in.RecepcionRequest;
import com.donatrack.donaciones.application.service.AdministradoraService;
import com.donatrack.donaciones.application.service.DonacionOriginalService;
import com.donatrack.donaciones.domain.model.Administradora;
import com.donatrack.donaciones.domain.model.Contacto;
import com.donatrack.donaciones.domain.model.Direccion;

import lombok.Data;

@RestController
@RequestMapping("/administradoras")
public class AdministradoraController {

	private final AdministradoraService administradoraService;
	private final DonacionOriginalService donacionOriginalService;

	public AdministradoraController(AdministradoraService administradoraService, DonacionOriginalService donacionOriginalService) {
		this.administradoraService = administradoraService;
		this.donacionOriginalService=donacionOriginalService;
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Administradora administradora) {
		administradoraService.create(administradora);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<List<Administradora>> getAll() {
		return ResponseEntity.ok(administradoraService.getAll());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") UUID id, @RequestBody UpdateRequest request) {
		administradoraService.update(id, request.contacto(), request.direccion());
		return ResponseEntity.ok().build();
	}

	public record UpdateRequest(Contacto contacto, Direccion direccion) {}
	 
	
	@PostMapping ("/{id}/recepcion_donacion")
	public ResponseEntity <Void> recibirDonacion(@PathVariable ("id") UUID id, @RequestBody RecepcionRequest request){
		administradoraService.asociarDonacionDonante(id,request.getId_donante(),request.getBienes(),request.getDescripcion());
		return ResponseEntity.ok().build();
	}

}
