package com.gestor.tareas.services;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestor.tareas.model.Persona;

import com.gestor.tareas.repository.PersonaRepositoryIface;



@Service
public class PersonaService implements PersonaServiceIface {

    private final PersonaRepositoryIface personaRepository;

    public PersonaService(PersonaRepositoryIface personaRepository){
        this.personaRepository = personaRepository;
    }

    @Override
    @Transactional
    public void guardarPersona(Persona persona) {
       personaRepository.save(persona);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Persona> obtener() {
        return personaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorNombre(String nombre) {
        return personaRepository.findByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorContraseña(String contraseña) {
        return personaRepository.findByContraseña(contraseña);
    }



    

    
    
}
