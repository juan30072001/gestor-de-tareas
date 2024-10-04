package com.gestor.tareas.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestor.tareas.model.Tarea;
import com.gestor.tareas.repository.TareaDAOIface;

@Service
public class TareaService implements TareaServiceIface {

    private final TareaDAOIface tareaDAO;

    public TareaService(TareaDAOIface tareaDAO){
        this.tareaDAO = tareaDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tarea> obtener() {
        return tareaDAO.findAll();
    }

    @Override
    @Transactional
    public void guardar(Tarea tarea) {
        tareaDAO.save(tarea);
    }

    @Override
    @Transactional(readOnly = true)
    public Tarea obtener(Long id) {
        return tareaDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        tareaDAO.deleteById(id);
    }
    
}
