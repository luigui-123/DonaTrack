package com.donatrack.incentivos.domain.model;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class Contacto {
    private String email;
    private String telefono;
    public Contacto(String email,String telefono){
        this.email=email;
        this.telefono=telefono;
    }

}
