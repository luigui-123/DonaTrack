package com.donatrack.incentivos.domain.model;
import org.bouncycastle.asn1.x509.SubjectAltPublicKeyInfo;

import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter 
public class Bien {
    private SubCategoria subCategoria;
    private String marca;
    public Bien (SubCategoria subCategoria,String marca){
        this.subCategoria=subCategoria;
        this.marca=marca;
    }
}
