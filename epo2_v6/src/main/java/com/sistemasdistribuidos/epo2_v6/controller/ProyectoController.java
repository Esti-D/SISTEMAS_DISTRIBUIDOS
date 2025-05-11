package com.sistemasdistribuidos.epo2_v6.controller;

import com.sistemasdistribuidos.epo2_v6.model.Proyecto;
import com.sistemasdistribuidos.epo2_v6.repository.ProyectoRepository;
import com.sistemasdistribuidos.epo2_v6.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador encargado de gestionar la interfaz web para operaciones con proyectos:
 * listar, crear, editar, eliminar y visualizar su localización en un mapa.
 */
@Controller
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private ProyectoRepository proyectoRepository;

    /**
     * Muestra la lista de todos los proyectos disponibles.
     *
     * @param model el modelo utilizado para pasar la lista a la vista.
     * @return la vista "proyectos".
     */
    @GetMapping("")
    public String listarProyectos(Model model) {
        List<Proyecto> lista = proyectoRepository.findAll();
        model.addAttribute("proyectos", lista);
        return "proyectos";
    }

    /**
     * Muestra el formulario para crear un nuevo proyecto.
     *
     * @param model el modelo utilizado para cargar el objeto vacío de proyecto.
     * @return la vista "crear-proyecto".
     */
    @GetMapping("/create")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        return "crear-proyecto";
    }

    /**
     * Guarda un nuevo proyecto recibido desde el formulario.
     *
     * @param proyecto el proyecto a guardar.
     * @return redirección a la vista de lista de proyectos.
     */
    @PostMapping("/save")
    public String guardarProyecto(@ModelAttribute Proyecto proyecto, Model model) {
        try {
            proyectoService.save(proyecto);
            return "redirect:/proyectos";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("error", "El nombre del proyecto ya existe.");
            model.addAttribute("proyecto", proyecto); // Para que no se borre el formulario
            return "crear-proyecto"; // Vuelve al formulario
        }
    }

    /**
     * Muestra el formulario para editar un proyecto existente.
     *
     * @param id    el identificador del proyecto.
     * @param model el modelo para cargar el proyecto a editar.
     * @return la vista de edición si el proyecto existe, o redirección si no.
     */
    @GetMapping("/edit/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") int id, Model model) {
        Proyecto proyecto = proyectoService.findById(id);
        if (proyecto != null) {
            model.addAttribute("proyecto", proyecto);
            return "editar-proyecto";
        } else {
            return "redirect:/proyectos";
        }
    }

    /**
     * Actualiza un proyecto existente con los nuevos datos.
     *
     * @param proyecto el proyecto actualizado.
     * @return redirección a la lista de proyectos.
     */
    @PostMapping("/update")
    public String actualizarProyecto(@ModelAttribute Proyecto proyecto) {
        proyectoService.save(proyecto);
        return "redirect:/proyectos";
    }

    /**
     * Elimina un proyecto dado su identificador.
     *
     * @param id el identificador del proyecto a eliminar.
     * @return redirección a la lista de proyectos.
     */
    @GetMapping("/delete/{id}")
    public String eliminarProyecto(@PathVariable("id") int id) {
        proyectoService.deleteById(id);
        return "redirect:/proyectos";
    }

    /**
     * Muestra la vista del mapa centrada en la ciudad asociada al proyecto.
     *
     * @param ciudad la ciudad donde se ubica el proyecto.
     * @param model  el modelo utilizado para pasar la ciudad a la vista.
     * @return la vista "mapa".
     */
    @GetMapping("/mapa/{ciudad}")
    public String mostrarMapaProyecto(@PathVariable("ciudad") String ciudad, Model model) {
        model.addAttribute("ciudad", ciudad);
        return "mapa";
    }
}

