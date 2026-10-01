package com.donatrack.donaciones.infrastructure.adapters.in.api;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.donatrack.donaciones.application.dto.in.AsignacionRequest;
import com.donatrack.donaciones.application.dto.in.RecepcionRequest;
import com.donatrack.donaciones.application.dto.out.RecomendacionesResponse;
import com.donatrack.donaciones.application.service.DonacionOriginalService;
import com.donatrack.donaciones.application.service.DonacionSegmentadaService;


@RestController
@RequestMapping ("/donaciones")
public class DonacionController {
    private DonacionOriginalService donacionOriginalService;
    private DonacionSegmentadaService donacionSegmentadaService;

    public DonacionController(DonacionOriginalService donacionOriginalService, DonacionSegmentadaService donacionSegmentadaService){
        this.donacionOriginalService =donacionOriginalService;
        this.donacionSegmentadaService = donacionSegmentadaService; 
    }
    @PostMapping ("donaciones")
    public ResponseEntity<Void> crearDonacionOriginal(@RequestBody RecepcionRequest recepcionDonacionRequest){
        this.donacionOriginalService.crear(recepcionDonacionRequest);
        return ResponseEntity.ok().build();
        
    }

    @GetMapping ("/recomendaciones")
    public ResponseEntity<List<RecomendacionesResponse>> obtenerRecomendaciones(){
        return ResponseEntity.ok(donacionSegmentadaService.obtenerRecomendacionesDonaciones());
    }
    @PatchMapping ("/asignar")
    public ResponseEntity<Void> asignarDonaciones(@RequestBody List<AsignacionRequest> asignacionRequests) {
        donacionSegmentadaService.realizarAsginaciones(asignacionRequests);
        return ResponseEntity.ok().build();
    
    }
       
}
