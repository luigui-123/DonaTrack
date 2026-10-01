package com.donatrack.logistica.domain.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cglib.core.Local;

public class Entrega {
    private Camion camion;
    private List<DonacionItem> donaciones;
    private Ruta ruta;
    private LocalDate fecha;
    private EstadoEntrega estadoEntrega;
    

    
}
