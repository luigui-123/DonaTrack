package com.donatrack.donaciones.application.dto.in;

import lombok.Data;

@Data 
public class FiltrosDonacionDTO {
    private String SubCatetegoria;
    private String Categoria;
    private String Estado;
}
