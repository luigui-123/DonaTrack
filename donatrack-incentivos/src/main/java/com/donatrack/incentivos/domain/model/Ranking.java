package com.donatrack.incentivos.domain.model;

import java.time.Month;

public class Ranking {
    private Month mes;
    private DonantePuntacion primero;
    private DonantePuntacion segundo;
    private DonantePuntacion tercero;
    public Ranking (Month mes, DonantePuntacion primero,DonantePuntacion segundo,DonantePuntacion tercero){
        this.primero=primero;
        this.segundo=segundo;
        this.tercero=tercero;
    }
}
