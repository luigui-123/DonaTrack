package com.donatrack.incentivos.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.donatrack.incentivos.application.port.out.repository.MisionRepository;
import com.donatrack.incentivos.domain.model.Mision;

@Service 
public class MisionService {
    private MisionRepository misionRepository;
    public MisionService(MisionRepository misionRepository){
        this.misionRepository=misionRepository;
    }
    public void crear(Mision mision){
        this.misionRepository.crear(mision);
    }
    public Mision buscarPorID(UUID id){
        return this.misionRepository.buscarPorID(id);
    }
    public List<Mision> obtenerMisionesEnRacha(){
        return this.misionRepository.obtenerTodos().stream().filter(m->m.getNombre().equals("Racha")).toList();
    }

    
}
