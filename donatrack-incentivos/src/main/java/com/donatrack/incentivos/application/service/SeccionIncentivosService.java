package com.donatrack.incentivos.application.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.donatrack.incentivos.application.dto.in.SeccionIncentivosUpdateRequest.SeccionIncentivosUpdateRequest;
import com.donatrack.incentivos.application.dto.out.AscensoMisionEvent;
import com.donatrack.incentivos.application.port.out.client.NotificacionesClient;
import com.donatrack.incentivos.application.port.out.repository.SeccionIncentivosRepository;
import com.donatrack.incentivos.domain.model.DonacionRecibida;
import com.donatrack.incentivos.domain.model.DonanteIncentivos;
import com.donatrack.incentivos.domain.model.EstadoSeccionIncentivos;
import com.donatrack.incentivos.domain.model.Mision;
import com.donatrack.incentivos.domain.model.SeccionIncentivos;

@Service 
public class SeccionIncentivosService {
    private SeccionIncentivosRepository seccionIncentivosRepository;
    private NotificacionesClient notificacionesClient;
    private MisionService misionService;
    public SeccionIncentivosService(SeccionIncentivosRepository seccionIncentivosRepository,NotificacionesClient notificacionesClient,MisionService misionService){
        this.seccionIncentivosRepository=seccionIncentivosRepository;
        this.notificacionesClient =notificacionesClient;
        this.misionService=misionService;
    }
    public void create(DonanteIncentivos donante){
        SeccionIncentivos seccionIncentivos = new SeccionIncentivos(donante);
        seccionIncentivosRepository.guardar(seccionIncentivos);
    }

    public void update(SeccionIncentivosUpdateRequest seccionIncentivosUpdateRequest) {
        
        //se busca la seccion en la BD
        SeccionIncentivos seccionIncentivos = seccionIncentivosRepository.buscarPorDonante(seccionIncentivosUpdateRequest.getId_donante());

        //actuliza cuando el donante realizo alguna donacion
        if(seccionIncentivosUpdateRequest.getDonacionNueva()!=null){
            seccionIncentivos.evaluarDonacionRecibida(seccionIncentivosUpdateRequest.getDonacionNueva());
        }
        
        //actuliza cuando el donante cambio sus datos personales
        if(seccionIncentivosUpdateRequest.getDonanteUpdateRequest()!=null){
            seccionIncentivos.actulizarDatosDonante(seccionIncentivosUpdateRequest.getDonanteUpdateRequest());
        }

        //actualiza cuando alguna donacion segmentada haya sido entregada a alguna beneficiaria
        if(seccionIncentivosUpdateRequest.getDonacionEntregada()!=null){
            seccionIncentivos.actulizarPorEntrega(seccionIncentivosUpdateRequest.getDonacionEntregada());
        }
        //guarda los cambios en la BD
        seccionIncentivosRepository.guardar(seccionIncentivos);

        //se evalua como queda el estado despues del update
        EstadoSeccionIncentivos estadoSeccionIncentivos = seccionIncentivos.informarEstadoSeccionIncentivos();
        
        if(estadoSeccionIncentivos.getSubioMision()){
            AscensoMisionEvent ascensoMisionEvent = new AscensoMisionEvent(seccionIncentivos);
            if(!estadoSeccionIncentivos.getSubioNivel()){
                ascensoMisionEvent.setNombreNivel(""); //se interpreta que no subio de nivel
            }
            this.notificacionesClient.enviarAscensoMisionEvent(ascensoMisionEvent);
        }

    }
    public SeccionIncentivos obtenerPorDonante(UUID id_donanteIncentivos){
        return seccionIncentivosRepository.buscarPorDonante(id_donanteIncentivos);
    }
    public List<SeccionIncentivos> obtenerTodos() {
        return this.seccionIncentivosRepository.obtenerTodos();
    }
    public void verificarExpiracionRachas(){
        this.seccionIncentivosRepository.obtenerTodos().stream().forEach(s->
            {if(s.getMisionActual().getNombre().equals("Racha")){
                s.getMisionActual().verificarYActualizarRacha();
            }
    });
    }
    


}