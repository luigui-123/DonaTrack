package com.donatrack.donaciones.domain.model;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Contacto {
    private String correoElectronico;
    private String telefono;
    private String whatsapp;
    private MedioContacto medioPredeterminado;

    public Contacto(String correoElectronico, String telefono, String whatsapp, MedioContacto medioPredeterminado) {
        actualizar(correoElectronico, telefono, whatsapp, medioPredeterminado);
    }
    
    public void actualizar(String correoElectronico, String telefono, String whatsapp, MedioContacto medioPredeterminado) {
        if (correoElectronico == null || correoElectronico.isBlank()) throw new IllegalArgumentException("El correo es obligatorio");
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.whatsapp = whatsapp;
        this.medioPredeterminado = medioPredeterminado == null ? MedioContacto.CORREO_ELECTRONICO : medioPredeterminado;
        if (this.medioPredeterminado == MedioContacto.TELEFONO && (telefono == null || telefono.isBlank())
                || this.medioPredeterminado == MedioContacto.WHATSAPP && (whatsapp == null || whatsapp.isBlank())) {
            throw new IllegalArgumentException("El medio predeterminado no esta disponible");
        }
    }
}