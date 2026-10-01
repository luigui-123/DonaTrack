package com.donatrack.incentivos.domain.model;

import java.util.List;

public class ProgresoTotal {
    Integer cantidadDonacionesRealizadas;
    Integer cantidadBeneficiariasAyudadas;
    Integer cantidadBieneDonados;
    Integer cantidadCategorias;
    public ProgresoTotal(List<Progreso> progresosRealizados){
        this.cantidadDonacionesRealizadas = progresosRealizados.size();
        this.cantidadBeneficiariasAyudadas = progresosRealizados.stream().mapToInt(p->p.getCantidadBeneficiariasAyudadas()).sum();
        this.cantidadBieneDonados = progresosRealizados.stream().mapToInt(d->d.getCantidadBienesDonados()).sum();
        this.cantidadCategorias = (int) progresosRealizados.stream().map(d->d.getCategorias()).flatMap(List::stream).distinct().count();
    }
}
