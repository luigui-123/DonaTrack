package com.donatrack.donaciones.application.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.donatrack.donaciones.application.dto.out.DonacionSegmentadaDTO;
import com.donatrack.donaciones.application.port.out.repository.BeneficiariaRepository;
import com.donatrack.donaciones.domain.model.Beneficiaria;
import com.donatrack.donaciones.domain.model.Contacto;
import com.donatrack.donaciones.domain.model.Direccion;
import com.donatrack.donaciones.domain.model.Necesidad;

@Service 
public class BeneficiariaService {
    private BeneficiariaRepository beneficiariaRepository;
    private DonacionSegmentadaService donacionSegmentadaService;
    public BeneficiariaService(BeneficiariaRepository beneficiariaRepository,DonacionSegmentadaService donacionSegmentadaService){
        this.beneficiariaRepository=beneficiariaRepository;
        this.donacionSegmentadaService = donacionSegmentadaService;
    }
    public void create (Beneficiaria beneficiaria){
        beneficiariaRepository.save(beneficiaria);
    }
    public List<Beneficiaria> getAll (){
        return beneficiariaRepository.findAll();
    }
    public void update(UUID id, Contacto contacto, Direccion direccion){ // son los unicos datos que nos importa si los cambia
        Beneficiaria beneficiaria = beneficiariaRepository.findById(id);
        beneficiaria.setContacto(contacto);
        beneficiaria.setDireccion(direccion);
        beneficiariaRepository.save(beneficiaria);
    }
    public void registrarNecesidad(UUID id_beneficiaria,Necesidad necesidad){
        
        Beneficiaria beneficiaria = beneficiariaRepository.findById(id_beneficiaria);
        beneficiaria.agregarNecesidad(necesidad);
        beneficiariaRepository.save(beneficiaria);
    }
    public List<DonacionSegmentadaDTO> obtenerDonacionesAsignadas(UUID id_beneficiaria){
        return donacionSegmentadaService.obtenerPorBeneficiaria(id_beneficiaria).stream().map(d->new DonacionSegmentadaDTO(d)).collect(Collectors.toList());
    }
    
}
