package com.gestor.tareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestor.tareas.model.Tarea;

@Repository
public interface TareaDAOIface extends JpaRepository<Tarea, Long> {
    
}
