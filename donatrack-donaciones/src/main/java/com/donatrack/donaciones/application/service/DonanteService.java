package com.donatrack.donaciones.application.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.donatrack.donaciones.application.dto.out.DonanteIncentivosDTO.DonanteIncentivosDTO;
import com.donatrack.donaciones.application.port.out.client.IncentivosClient;
import com.donatrack.donaciones.application.port.out.repository.DonanteRepository;
import com.donatrack.donaciones.domain.model.Contacto;
import com.donatrack.donaciones.domain.model.Direccion;
import com.donatrack.donaciones.domain.model.DocumentoIdentidad;
import com.donatrack.donaciones.domain.model.DonacionSegmentada;
import com.donatrack.donaciones.domain.model.Donante;
import com.donatrack.donaciones.infrastructure.adapters.out.client.IncentivoClient;

@Service
public class DonanteService {
    private DonanteRepository donanteRepository;
    private IncentivosClient incentivosClient;

    public DonanteService(DonanteRepository donanteRepository,IncentivosClient incentivosClient){
        this.donanteRepository = donanteRepository;
        this.incentivosClient=incentivosClient;
    }
    public void create(Donante donante){
        donanteRepository.save(donante);
        incentivosClient.enviarDonante(new DonanteIncentivosDTO(donante));
    } 
    public List<Donante> getAll(){
        return donanteRepository.findAll();
    }
    public void update (UUID id,Direccion direccion, Contacto contacto){
        Donante donante = donanteRepository.findById(id);
        donante.setContacto(contacto);
        donante.setDireccion(direccion);
        donanteRepository.save(donante);
    }
    public List<DonacionSegmentada> filtrarDonaciones(String estado, String Categoria, String SubCategoria){
        return null;
    }
    public boolean existe(UUID id_donante) {
        return this.donanteRepository.findAll().stream().anyMatch(d->d.getIdPersona().equals(id_donante));
    }
    public Donante buscarPorId(UUID id_donante) {
        return this.donanteRepository.findById(id_donante);
    } 
    public Donante buscarPorDocumento(DocumentoIdentidad documentoIdentidad){
        return donanteRepository.buscarPorDocumento(documentoIdentidad);
    }
    
}
