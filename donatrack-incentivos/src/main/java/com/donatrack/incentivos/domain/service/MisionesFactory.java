package com.donatrack.incentivos.domain.service;

import java.util.ArrayList;
import java.util.List;
import com.donatrack.incentivos.domain.model.Completitud;
import com.donatrack.incentivos.domain.model.DonacionesExitosas;
import com.donatrack.incentivos.domain.model.HabilDonador;
import com.donatrack.incentivos.domain.model.Insignia;
import com.donatrack.incentivos.domain.model.Mision;
import com.donatrack.incentivos.domain.model.Racha;

public class MisionesFactory {
    public List<Mision> crearMisiones() {
        List<Mision> misiones = new ArrayList<>();

        misiones.add(new Racha(
                "Realizar donaciones durante 3 meses consecutivos",
                3,
                new Insignia("Donante constante", "Realizaste donaciones durante 3 meses consecutivos")));
        misiones.add(new Completitud(
                "Donar en 3 categorias distintas",
                3,
                new Insignia("Donante diverso", "Realizaste donaciones de 3 categorias distintas"),
                null));
        misiones.add(new HabilDonador(
                "Donar mas de 10 bienes",
                10,
                new Insignia("Habil donador", "Donaste mas de 10 bienes")));
        misiones.add(new DonacionesExitosas(
                "Lograr 3 donaciones recibidas exitosamente",
                3,
                new Insignia("Donante efectivo", "Lograste 3 donaciones recibidas exitosamente")
                ));

        return misiones;
    }
}
