package com.donatrack.donaciones.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.donatrack.donaciones.application.dto.in.AsignacionRequest;
import com.donatrack.donaciones.application.dto.in.FiltrosDonacionDTO;
import com.donatrack.donaciones.application.dto.out.DonacionSegmentadaDTO;
import com.donatrack.donaciones.application.dto.out.RecomendacionesResponse;
import com.donatrack.donaciones.application.port.out.client.LogisticaClient;
import com.donatrack.donaciones.application.port.out.repository.DonacionSegmentadaRepository;
import com.donatrack.donaciones.domain.model.Beneficiaria;
import com.donatrack.donaciones.domain.model.DonacionSegmentada;
import com.donatrack.donaciones.domain.model.TipoEstadoDonacion;
import com.donatrack.donaciones.domain.service.RecomendacionDonacionBeneficiaria;

@Service 
public class DonacionSegmentadaService {

    private DonacionSegmentadaRepository donacionSegmentadaRepository;
    private BeneficiariaService beneficiariaService; 
    private LogisticaClient logisticaClient;
    public DonacionSegmentadaService(DonacionSegmentadaRepository donacionSegmentadaRepository,DonacionSegmentada donacionSegmentada,BeneficiariaService beneficiariaService, LogisticaClient logisticaClient){
        this.donacionSegmentadaRepository=donacionSegmentadaRepository;
        this.beneficiariaService = beneficiariaService;
        this.logisticaClient = logisticaClient;
    }

    public void crear(DonacionSegmentada donacionSegmentada){
        donacionSegmentadaRepository.save(donacionSegmentada);
    }
    public List<DonacionSegmentadaDTO> filtraDoancionesPorFiltros(UUID id_donante,FiltrosDonacionDTO filtrosDonacionDTO)
    {
        List<DonacionSegmentada> donacionSegmentadas = donacionSegmentadaRepository.findByIdDonante(id_donante);
        List<DonacionSegmentada> donacionesFiltradas = new ArrayList<>();
        if(filtrosDonacionDTO.getEstado() ==null && filtrosDonacionDTO.getCategoria() == null && filtrosDonacionDTO.getSubCatetegoria() != null){
            donacionesFiltradas = donacionSegmentadas.stream().filter(donacion -> donacion.getSubCategoriaDonacion() == filtrosDonacionDTO.getSubCatetegoria()).collect(Collectors.toList());
        }else if(filtrosDonacionDTO.getSubCatetegoria() == null){
            donacionesFiltradas = donacionSegmentadas.stream().filter(d->filtrosDonacionDTO.getCategoria() != null? d.getCategoriaDonacion() == filtrosDonacionDTO.getCategoria(): true  ).collect(Collectors.toList()).stream().filter(d->filtrosDonacionDTO.getEstado() != null? d.getEstadoActual() == filtrosDonacionDTO.getEstado(): true  ).collect(Collectors.toList());
        }
        return donacionesFiltradas.stream().map(d->new DonacionSegmentadaDTO(d)).collect(Collectors.toList());
        
    }

    public List<DonacionSegmentada> obtenerPorBeneficiaria(UUID id_beneficiaria) {
        return donacionSegmentadaRepository.buscarPorBeneficiaria(id_beneficiaria);
    }
    public void crearRecomendacionesDonaciones(){
        RecomendacionDonacionBeneficiaria recomendador = new RecomendacionDonacionBeneficiaria();
        List<DonacionSegmentada> donacionesEnDeposito = donacionSegmentadaRepository.findAll().stream().filter(d->d.getEstadoActual() == "DEPOSITO").collect(Collectors.toList());
        List<Beneficiaria> beneficiariasDisponibles = beneficiariaService.getAll();
        for(DonacionSegmentada d: donacionesEnDeposito){
            d.setBeneficiariasRecomendadas(recomendador.recomendarBeneficiarias(d,beneficiariasDisponibles)); 
            donacionSegmentadaRepository.save(d);
        }    
    }
    public List<RecomendacionesResponse> obtenerRecomendacionesDonaciones (){
        List<DonacionSegmentada> donacionesEnDeposito = donacionSegmentadaRepository.findAll().stream().filter(d->d.getEstadoActual() == "DEPOSITO").collect(Collectors.toList());
        List<RecomendacionesResponse> recomendacionesResponses = new ArrayList<>();
        for(DonacionSegmentada d : donacionesEnDeposito){
            recomendacionesResponses.add(new RecomendacionesResponse(new DonacionSegmentadaDTO(d), d.getBeneficiariasRecomendadas()));
        }
        return recomendacionesResponses;

    }
    public void realizarAsginaciones(List<AsignacionRequest> asignacionRequests){
        for(AsignacionRequest a : asignacionRequests){
            DonacionSegmentada donacionSegmentada = donacionSegmentadaRepository.findById(a.getDonacionSegmentadaDTO().getId_donacionSegmentada());
            //cambio el estado de la donaciones asignadas
            donacionSegmentada.asignarBeneficiaria(a.getBeneficiaria());
            donacionSegmentadaRepository.save(donacionSegmentada);
            //ahora se lo voy a pasar al servicios logistica para que los planifique, la cola debera tener 100 donacione segmentada para iniciar el proceso de planificacion
            this.logisticaClient.enviarDonacionAsignada(a.getDonacionSegmentadaDTO());
            

        }

    }
    public void verificarDonacionesVencidas(){
        List<DonacionSegmentada> donacionesSegmentadas = this.donacionSegmentadaRepository.findAll().stream().filter(d->d.estaVencida() ).toList();
        donacionesSegmentadas.forEach(d->d.cambiarEstado(TipoEstadoDonacion.VENCIDA));
        donacionesSegmentadas.forEach(d->this.donacionSegmentadaRepository.save(d));

    }
}

