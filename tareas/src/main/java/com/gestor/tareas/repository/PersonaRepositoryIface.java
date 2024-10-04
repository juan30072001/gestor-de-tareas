package com.gestor.tareas.repository;



import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestor.tareas.model.Persona;

@Repository
public interface PersonaRepositoryIface extends JpaRepository<Persona, Long> {

    public Optional<Persona> findByNombre(String nombre);
    public Optional<Persona> findByContraseña(String contraseña);
    
}
