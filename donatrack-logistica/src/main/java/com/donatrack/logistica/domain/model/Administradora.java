package com.donatrack.logistica.domain.model;

import java.rmi.server.UID;
import java.util.UUID;

public class Administradora {
    private UUID id_administradora;
    private String nombre;
    private Deposito deposito;
    public Administradora(String nombre,Deposito deposito){
        this.id_administradora = UUID.randomUUID();
        this.nombre=nombre;
        this.deposito = deposito;
    }
}
