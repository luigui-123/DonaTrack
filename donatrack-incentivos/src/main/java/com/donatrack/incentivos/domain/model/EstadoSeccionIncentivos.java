package com.donatrack.incentivos.domain.model;


import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 

public class EstadoSeccionIncentivos {
    private Boolean subioMision;
    private Boolean subioNivel;
    public EstadoSeccionIncentivos(Boolean subioMision,Boolean subioNivel){
        this.subioMision=subioMision;
        this.subioNivel=subioNivel;
    }

}
