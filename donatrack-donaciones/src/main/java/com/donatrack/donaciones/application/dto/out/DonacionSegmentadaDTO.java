package com.donatrack.donaciones.application.dto.out;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.donatrack.donaciones.domain.model.DonacionSegmentada;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DonacionSegmentadaDTO {
    private UUID id_donacionSegmentada;
    private List<String> nombresBienes;
    private String SubCategoria;
    private String Categoria;
    private String EstadoDonacion;

    public DonacionSegmentadaDTO(DonacionSegmentada donacionSegmentada){
        this.id_donacionSegmentada = donacionSegmentada.getIdDonacionSegmentada();
        this.nombresBienes=donacionSegmentada.getBienes().stream().map(bien->bien.getNombre()).collect(Collectors.toList());
        this.SubCategoria = donacionSegmentada.getSubCategoriaDonacion();
        this.Categoria=donacionSegmentada.getSubCategoriaDonacion();
        this.EstadoDonacion = donacionSegmentada.getEstadoActual();
    }
}
