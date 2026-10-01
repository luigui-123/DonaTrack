package com.donatrack.incentivos.domain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class DonacionRecibida {
    private UUID id_donacionRecibida;
    private LocalDate fecha;
    private List<DonacionSegmentada> donacionSegmentadas;
    private DonanteIncentivos donanteIncentivos;
    
    

    public Progreso obtenerProgreso(){
        return new Progreso(this.cantidadBeneficiariasAyudadas(),this.cantidadBienesRecibidos(),this.categoriasDonaciones());
    }
    public Integer cantidadBienesRecibidos(){
        return this.donacionSegmentadas.stream().mapToInt(d->d.cantidadBienes()).sum();
    }
    public Integer cantidadBeneficiariasAyudadas(){
        return (int) this.donacionSegmentadas.stream().filter(d->d.getEstaEntregada()).count();
    }
    public List<Categoria> categoriasDonaciones(){
        return this.donacionSegmentadas.stream().map(d->d.getCategoria()).distinct().toList();
    }
    
}
