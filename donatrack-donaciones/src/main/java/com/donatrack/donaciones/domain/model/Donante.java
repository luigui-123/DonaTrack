package com.donatrack.donaciones.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class Donante extends Persona {
    private final List<DonacionOriginal> donacionesRealizadas;
    private LocalDate ultimaFechaActivo;
    private String rol;

    public Donante(Direccion direccion, Contacto contacto,TipoPersona tipoPersona,DocumentoIdentidad documentoIdentidad) {
        super(direccion, contacto,tipoPersona,documentoIdentidad);
        this.ultimaFechaActivo = LocalDate.now();
        this.donacionesRealizadas = new ArrayList<>();
        this.rol= "donante";
    }
    public boolean estaActivo() {
        return ultimaFechaActivo.isAfter(LocalDate.now().minusMonths(1));
    }
    public void registrarDonacion(DonacionOriginal donacion) {
        donacionesRealizadas.add(donacion);
    }
}