package com.donatrack.donaciones.application.service;

import com.donatrack.donaciones.application.dto.in.RecepcionRequest;
import com.donatrack.donaciones.application.port.out.repository.DonacionOriginalRepository;
import com.donatrack.donaciones.domain.model.Administradora;
import com.donatrack.donaciones.domain.model.DonacionOriginal;
import com.donatrack.donaciones.domain.model.Donante;

public class DonacionOriginalService {
    private DonacionOriginalRepository donacionOriginalRepository;
    private DonacionSegmentadaService donacionSegmentadaService;
    private AdministradoraService administradoraService;
    private DonanteService donanteService;
    public DonacionOriginalService(DonacionOriginalRepository donacionOriginalRepository, AdministradoraService administradoraService,DonanteService donanteService,DonacionSegmentadaService donacionSegmentadaService){
        this.donacionOriginalRepository =  donacionOriginalRepository;
        this.administradoraService = administradoraService;
        this.donanteService = donanteService;
        this.donacionSegmentadaService = donacionSegmentadaService;
    }

    public void crear(RecepcionRequest recepcionRequest) {
        Administradora  administradora= administradoraService.buscarPorId(recepcionRequest.getId_administradora());
        Donante donante = donanteService.buscarPorId(recepcionRequest.getId_donante());
        DonacionOriginal donacionOriginal = new DonacionOriginal(recepcionRequest.getDescripcion(),donante, administradora, recepcionRequest.getBienes());
        donacionOriginalRepository.guardar(donacionOriginal);
        donacionOriginal.getDonacionesSegmentadas().stream().forEach(d->donacionSegmentadaService.crear(d));
    }
    
}
