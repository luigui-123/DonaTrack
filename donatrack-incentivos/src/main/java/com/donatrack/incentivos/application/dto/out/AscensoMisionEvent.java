package com.donatrack.incentivos.application.dto.out;

import com.donatrack.incentivos.domain.model.Contacto;
import com.donatrack.incentivos.domain.model.SeccionIncentivos;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 

public class AscensoMisionEvent {
    private String nombreMision;
    private String nombreNivel;
    private String nombreInsignia;
    private String nombreDonante;
    private Contacto contacto;

    public AscensoMisionEvent (SeccionIncentivos seccionIncentivos){
        this.nombreMision=seccionIncentivos.getMisionActual().getNombre();
        this.nombreNivel= seccionIncentivos.getNivelActual();
        this.nombreInsignia = seccionIncentivos.getInsignias().getLast().getNombre();
        this.nombreDonante=seccionIncentivos.getDonante().getNombre();
        this.contacto = seccionIncentivos.getDonante().getContacto();
    }
}
