package com.donatrack.incentivos.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.geo.Point;

import com.donatrack.incentivos.application.dto.in.SeccionIncentivosUpdateRequest.DonacionEntregadaDTO;
import com.donatrack.incentivos.application.dto.in.SeccionIncentivosUpdateRequest.DonanteUpdateRequest;
import com.donatrack.incentivos.domain.service.MisionesFactory;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class SeccionIncentivos {

    private DonanteIncentivos donante;
    private List<Progreso> progresos;
    private List<Insignia> insignias;
    private List<Mision> misiones;
    private Mision misionActual;

    public SeccionIncentivos(DonanteIncentivos donante) {
        MisionesFactory misionesFactory = new MisionesFactory();
        this.misiones= misionesFactory.crearMisiones();
        this.dividirMisionesEnNiveles();
        this.insignias = new ArrayList<>();
    }
    public void dividirMisionesEnNiveles(){
        Integer cantidadNiveles = this.misiones.size();
        Integer resto = cantidadNiveles % 3;
        if(resto==1){
            cantidadNiveles--;
        }
        if(resto == 2){
            cantidadNiveles -=2;
        }
        Integer cantidadMisionesPorNivel = cantidadNiveles/3;
        this.misiones.subList(0, cantidadMisionesPorNivel-1).forEach(m->m.setNivel("Colaborador"));
        this.misiones.subList(cantidadMisionesPorNivel-1, 2* cantidadMisionesPorNivel -1).forEach(m->m.setNivel("Sostenedor"));
        this.misiones.subList(2*cantidadMisionesPorNivel-1,cantidadNiveles).forEach(m->m.setNivel("Transformador"));
    }

    public ProgresoTotal obtenerProgresoTotalActual(){
        return new ProgresoTotal(this.progresos);
    }
    
    public void evaluarDonacionRecibida(DonacionRecibida donacionRecibida){
        this.progresos.add(donacionRecibida.obtenerProgreso());
        this.evaluarSeccionIncentivos(donacionRecibida.obtenerProgreso());
    }
    public void evaluarSeccionIncentivos(Progreso progreso){
        this.misionActual.evaluarMision(progreso);
        if(this.misionActual.getEstaCompletado()){
            this.insignias.add(this.misionActual.getInsignia());
            this.subirMision();
        }
    }
    public void subirMision(){
        this.misionActual = this.misiones.get(this.misiones.indexOf(this.misionActual)+1);
        this.misionActual.setFechaInicio();

    }

    public String getNivelActual(){
        return this.misionActual.getNivel();
    }

    public Long cantidadMisionesCumplidasPorMes(){
        return misiones.stream().filter(m->m.getEstaCompletado() && m.getFechaFin().getMonth() == LocalDate.now().getMonth()).count();
    }
    public void actulizarDatosDonante(DonanteUpdateRequest donanteUpdateRequest) {
        this.donante.actualizarInformacion(donanteUpdateRequest);
    }

    public void actulizarPorEntrega(DonacionEntregadaDTO donacionEntregada) {
        
        this.evaluarSeccionIncentivos(new Progreso(1, null, null));       
    }
    
    public Mision misionAnteriorALaActual(){
        Integer indiceActual = this.misiones.indexOf(this.misionActual);
        return this.misiones.get(indiceActual-1);
    }
    public EstadoSeccionIncentivos informarEstadoSeccionIncentivos(){
        if(this.misiones.indexOf(this.misionActual) == 0){
            return new EstadoSeccionIncentivos(false,false);
        }
        return new EstadoSeccionIncentivos(!this.misionActual.equals(this.misionAnteriorALaActual()), !this.misionActual.getNivel().equals(this.misionAnteriorALaActual().getNivel()));
    }
    
    
    
}
