package com.donatrack.donaciones.domain.service;

import java.util.ArrayList;
import java.util.List;
import com.donatrack.donaciones.application.dto.in.CSVrequest;
import com.donatrack.donaciones.domain.model.Contacto;
import com.donatrack.donaciones.domain.model.DocumentoIdentidad;
import com.donatrack.donaciones.domain.model.Donante;
import com.donatrack.donaciones.domain.model.PersonaHumana;
import com.donatrack.donaciones.domain.model.PersonaJuridica;
import com.donatrack.donaciones.domain.model.TipoDocumento;

public class DonanteFactory {
    public Donante crearDonante( CSVrequest request){

        String [] nombre = request.getNombre().split(" ");
        List<String> tipos = new ArrayList<>();
        tipos.add("Humana");
        tipos.add("Juridica");
        if(!tipos.contains(request.getTipoPersona())){
            throw new IllegalArgumentException("El tipo de persona debe ser jurida o humana");

        }
        return  new Donante(
            null,
            new Contacto(request.getEmail(),
            request.getTelefono(),null,null),
            request.getTipoPersona()=="Humana"? new PersonaHumana(nombre[0], nombre[1], null, null): new PersonaJuridica(request.getNombre(), null, null),
            new DocumentoIdentidad(TipoDocumento.valueOf(request.getTipoDocumento()), request.getDocumento())
        );


    }
    
}
