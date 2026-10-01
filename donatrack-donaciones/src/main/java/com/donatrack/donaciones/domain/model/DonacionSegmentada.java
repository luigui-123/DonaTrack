package com.donatrack.donaciones.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter 


public class DonacionSegmentada {

    private final UUID idDonacionSegmentada;
    private final LocalDate fecha ;
    private final List<Bien> bienes;
    private final Donante donante;
    private Beneficiaria beneficiaria;
    private final List<EstadoDonacion> historialEstado = new ArrayList<>();
    private List<Beneficiaria> beneficiariasRecomendadas;
   
    public DonacionSegmentada(List<Bien> bienes, Donante donante) {
        if (bienes == null || donante == null) throw new IllegalArgumentException("Donacion segmentada invalida");
        this.idDonacionSegmentada = UUID.randomUUID();
        this.bienes = new ArrayList<>(bienes);
        this.donante = donante;
        this.beneficiaria = null;
        this.fecha = LocalDate.now();
        historialEstado.add(new EstadoDonacion(TipoEstadoDonacion.EN_DEPOSITO));
        this.beneficiariasRecomendadas = new ArrayList<>();
    }
    public String getEstadoActual()
    {
        return this.historialEstado.getLast().getEstado().toString();
    }
    public void asignarBeneficiaria(Beneficiaria beneficiaria) 
    { 
        this.beneficiaria = beneficiaria; 
        cambiarEstado(TipoEstadoDonacion.ASIGNADA); 
    }
    public void cambiarEstado(TipoEstadoDonacion estado) 
    { if (estado == null) 
        throw new IllegalArgumentException("Estado obligatorio");  
        historialEstado.add(new EstadoDonacion(estado)); 
    }
    public String getSubCategoriaDonacion(){
        return this.getBienes().get(0).getSubcategoria().toString();
    }
    public String getCategoriaDonacion(){
        return this.getBienes().get(0).getSubcategoria().getCategoria().toString();
    }
    public Boolean estaVencida(){
        return this.bienes.stream().anyMatch(b->b.estaVencida());
    }
}