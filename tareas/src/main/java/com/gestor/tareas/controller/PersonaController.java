package com.gestor.tareas.controller;



import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gestor.tareas.model.Persona;
import com.gestor.tareas.services.PersonaServiceIface;


@Controller
public class PersonaController {

    private final PersonaServiceIface personaService;

    public PersonaController(PersonaServiceIface personaService){
        this.personaService=personaService;
    }


    @GetMapping("/login")
    public String login(Persona persona, Model model) {
        model.addAttribute("persona", persona);
        model.addAttribute("titulo", "Login");
        return "vistas/login";
    }

    @PostMapping("/procesarpersona")
    public String procesarPersona(Persona persona, Model model){
        Optional<Persona> personasnombre = personaService.buscarPorNombre(persona.getNombre());
        Optional<Persona> personascontraseña = personaService.buscarPorContraseña(persona.getContraseña());
        if (personasnombre.isPresent() && personascontraseña.isPresent()) {
            return "redirect:/principal";
        }else{
            model.addAttribute("mensaje", "Usuario o contraseña incorrecto");
            model.addAttribute("titulo", "Login");
            return "vistas/login";
        }
    }

    @GetMapping("/registrar")
    public String registro(Persona persona, Model model){
        model.addAttribute("titulo", "Registro de usuario nuevo");
        model.addAttribute("persona", persona);
        return "vistas/registro";
    }

    @PostMapping("/procesarPersona")
    public String procesarRegistro(@ModelAttribute Persona persona, Model model){
        
        Optional<Persona> personasnombres = personaService.buscarPorNombre(persona.getNombre());
        if (personasnombres.isPresent()) {
            model.addAttribute("titulo", "Registro de usuario nuevo"); 
            model.addAttribute("mensaje", "Usuario ya existe");
            return "vistas/registro";
        }else{
            model.addAttribute("titulo", "Login");
            personaService.guardarPersona(persona);
            return "vistas/login";


    }

}
}
