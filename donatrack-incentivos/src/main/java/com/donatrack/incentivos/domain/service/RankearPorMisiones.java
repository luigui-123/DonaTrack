package com.donatrack.incentivos.domain.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.time.Month;

import com.donatrack.incentivos.domain.model.DonantePuntacion;
import com.donatrack.incentivos.domain.model.Ranking;
import com.donatrack.incentivos.domain.model.SeccionIncentivos;

public class RankearPorMisiones implements RankearStrategy{
    @Override 
    public Ranking rankear(List<SeccionIncentivos> perfiles){
        perfiles.sort(Comparator.comparing(SeccionIncentivos::cantidadMisionesCumplidasPorMes));
        List<SeccionIncentivos> mejoresPerfiles = perfiles.subList(0, 3);
        Ranking ranking = new Ranking(
            LocalDate.now().getMonth(),
            new DonantePuntacion(mejoresPerfiles.get(0).getDonante().getNombre(), mejoresPerfiles.get(0).cantidadMisionesCumplidasPorMes()),
            new DonantePuntacion(mejoresPerfiles.get(1).getDonante().getNombre(), mejoresPerfiles.get(1).cantidadMisionesCumplidasPorMes()),
            new DonantePuntacion(mejoresPerfiles.get(2).getDonante().getNombre(), mejoresPerfiles.get(2).cantidadMisionesCumplidasPorMes())
        );
        return ranking;
    
    }
}
