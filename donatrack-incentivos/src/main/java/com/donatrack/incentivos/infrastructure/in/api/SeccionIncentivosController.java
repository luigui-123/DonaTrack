package com.donatrack.incentivos.infrastructure.in.api;

import java.time.Month;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donatrack.incentivos.application.dto.in.SeccionIncentivosUpdateRequest.SeccionIncentivosUpdateRequest;
import com.donatrack.incentivos.application.service.DonanteIncentivosService;
import com.donatrack.incentivos.application.service.RankingService;
import com.donatrack.incentivos.application.service.SeccionIncentivosService;
import com.donatrack.incentivos.domain.model.DonacionRecibida;
import com.donatrack.incentivos.domain.model.DonanteIncentivos;
import com.donatrack.incentivos.domain.model.Ranking;

@RestController
@RequestMapping("/seccionesIncentivos")

public class SeccionIncentivosController {

	private SeccionIncentivosService seccionIncentivosService;
	private RankingService rankingService;
	
	public SeccionIncentivosController(SeccionIncentivosService SeccionIncentivosService,RankingService rankingService) {
		this.seccionIncentivosService = SeccionIncentivosService;
		this.rankingService= rankingService;
	}
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody DonanteIncentivos donante) {
		seccionIncentivosService.create(donante);
		return ResponseEntity.ok().build();
	}
	@PutMapping() // el que lo actuliza puede ser el servicio de donaciones o logistica
	public ResponseEntity<Void> actualizar( @RequestBody SeccionIncentivosUpdateRequest seccionIncentivosUpdateRequest) {
		seccionIncentivosService.update(seccionIncentivosUpdateRequest);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/rankings")
	public ResponseEntity<Ranking> obtenerRankingMesual(@RequestBody Month mes){
		return ResponseEntity.ok(rankingService.obtenerRankingMensual(mes));
		
	}
	

	
}

