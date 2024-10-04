package com.gestor.tareas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.gestor.tareas.model.Tarea;

import com.gestor.tareas.services.TareaServiceIface;

import jakarta.validation.Valid;

import java.util.List;

@Controller
@SessionAttributes("tarea")
public class TareasController {

    private final TareaServiceIface tareaService;

    public TareasController(TareaServiceIface tareaService){
        this.tareaService=tareaService;
    }


    @GetMapping("/principal")
    public String principal(Tarea tarea, Model model){
        List<Tarea> tareas = tareaService.obtener();
        model.addAttribute("tareas", tareas);
        model.addAttribute("titulo", "Gestor de tareas");
        model.addAttribute("tarea", tarea);

        return "vistas/principal";
    }

    @PostMapping("/procesartarea")
    public String procesarTarea(@Valid @ModelAttribute Tarea tarea, BindingResult result, Model model, SessionStatus status){
        if (result.hasErrors()){
            model.addAttribute("titulo", "Gestor de tareas");
            return "vistas/principal";
            
        }else{
            tareaService.guardar(tarea);
            return "redirect:/lista";
        }
    }
    
    @GetMapping("/lista")
    public String listaTareas(Tarea tarea, Model model){
        List<Tarea> tareas = tareaService.obtener();
        model.addAttribute("tareas", tareas);
        model.addAttribute("titulo", "Gestor de tareas");
        model.addAttribute("mensaje", "Tarea agregada");
        System.out.println(tarea.getId());
        return "vistas/principal";

    }

    @GetMapping("/consulta/{id}")
    public String consulta(@PathVariable Long id, Model model){
        Tarea tarea = tareaService.obtener(id);
        model.addAttribute("tarea", tarea);
        model.addAttribute("mensaje", "Consulta de la tarea: "+tarea.getNombre());
        model.addAttribute("titulo", "Gestor de tareas");
        System.out.println("prueba: "+tarea.getId());
        return "vistas/consulta";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, Model model){
        tareaService.eliminar(id);
        return "redirect:/lista";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, Model model){
        Tarea tarea = tareaService.obtener(id);
        model.addAttribute("tarea", tarea);
        return "vistas/principal";

    }
    
}



