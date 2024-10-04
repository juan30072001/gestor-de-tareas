package com.gestor.tareas.services;

import java.util.List;

import com.gestor.tareas.model.Tarea;

public interface TareaServiceIface {
    public List<Tarea> obtener();
    public void guardar(Tarea tarea);
    public Tarea obtener(Long id);
    public void eliminar(Long id);
}
