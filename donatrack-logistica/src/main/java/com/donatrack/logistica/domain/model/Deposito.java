package com.donatrack.logistica.domain.model;

import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;


public class Deposito {
  private UUID id;
  private List<Camion> camiones;
  private DonacionTotal donacionTotal;

  
}
