package com.gestor.tareas.services;

import java.util.List;

import java.util.Optional;


import com.gestor.tareas.model.Persona;

public interface PersonaServiceIface {

    public List<Persona> obtener();
    public void guardarPersona(Persona persona);
    public Optional<Persona> buscarPorNombre(String nombre);
    public Optional<Persona> buscarPorContraseña(String contraseña);
    
}
