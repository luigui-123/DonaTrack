package com.donatrack.donaciones.application.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.donatrack.donaciones.application.dto.in.RecepcionRequest;
import com.donatrack.donaciones.application.port.out.repository.AdministradoraRepository;
import com.donatrack.donaciones.domain.model.Administradora;
import com.donatrack.donaciones.domain.model.Bien;
import com.donatrack.donaciones.domain.model.Contacto;
import com.donatrack.donaciones.domain.model.Direccion;
import com.donatrack.donaciones.domain.model.DonacionOriginal;
import com.donatrack.donaciones.domain.model.DonacionSegmentada;


@Service 
public class AdministradoraService {
    
    private AdministradoraRepository administradoraRepository;
    private DonanteService donanteService;
    private AdministradoraService administradoraService;
    private DonacionOriginalService donacionOriginalService;
    private DonacionSegmentadaService donacionSegmentadaService;
    public AdministradoraService(AdministradoraRepository administradoraRepository,DonanteService donanteService, AdministradoraService administradoraService, DonacionOriginalService donacionOriginalService,DonacionSegmentadaService donacionSegmentadaService)
    {
        this.donacionSegmentadaService = donacionSegmentadaService;
        this.donacionOriginalService = donacionOriginalService;
        this.administradoraService = administradoraService;
        this.administradoraRepository = administradoraRepository;
        this.donanteService=donanteService;
    }
    public void create(Administradora administradora){
        administradoraRepository.save(administradora);
    }
    public List<Administradora> getAll(){
        return administradoraRepository.findAll();
    }
    public void update(UUID id, Contacto contacto, Direccion direccion){ // son los unicos datos que nos importa si los cambia
        Administradora administradora = administradoraRepository.findById(id);
        administradora.setContacto(contacto);
        administradora.setDireccion(direccion);
    }

    public Administradora buscarPorId(UUID id_admistradora) {
        return this.administradoraRepository.findById(id_admistradora);
    }

    public void asociarDonacionDonante(UUID id_admistradora,UUID id_donante,List<Bien>bienes,String descripcion){
        if(!donanteService.existe(id_donante)){
            throw new IllegalArgumentException("No existe el donante");
        }
        DonacionOriginal donacionOriginal = new DonacionOriginal(descripcion, donanteService.buscarPorId(id_donante), administradoraService.buscarPorId(id_admistradora), bienes);
        donacionOriginalService.crear(new RecepcionRequest(id_donante,id_admistradora,bienes,descripcion));
        for(DonacionSegmentada d : donacionOriginal.getDonacionesSegmentadas()){
            donacionSegmentadaService.crear(d);
        }
    }
    

}
