package com.sistemasdistribuidos.epo2_v6.controller;

import com.sistemasdistribuidos.epo2_v6.model.Subsistema;
import com.sistemasdistribuidos.epo2_v6.service.SubsistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador encargado de gestionar la interfaz web para operaciones con subsistemas:
 * listar, crear, editar y eliminar.
 */
@Controller
@RequestMapping("/subsistemas")
public class SubsistemaController {

    @Autowired
    private SubsistemaService subsistemaService;

    /**
     * Muestra la lista de subsistemas disponibles.
     *
     * @param model el modelo utilizado para pasar la lista a la vista.
     * @return el nombre de la vista "subsistemas".
     */
    @GetMapping
    public String listarSubsistemas(Model model) {
        model.addAttribute("subsistemas", subsistemaService.findAll());
        return "subsistemas";
    }

    /**
     * Muestra el formulario para crear un nuevo subsistema.
     *
     * @param model el modelo que contiene un objeto vacío de subsistema.
     * @return el nombre de la vista "crear-subsistema".
     */
    @GetMapping("/create")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("subsistema", new Subsistema());
        return "crear-subsistema";
    }

    /**
     * Guarda un nuevo subsistema enviado desde el formulario.
     *
     * @param subsistema el subsistema a guardar.
     * @return redirección a la lista de subsistemas.
     */
    @PostMapping("/save")
    public String guardarSubsistema(@ModelAttribute Subsistema subsistema, Model model) {
        try {
            subsistemaService.save(subsistema);
            return "redirect:/subsistemas";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar subsistema: " + e.getMessage());
            return "crear-subsistema";
        }
    }

    /**
     * Muestra el formulario para editar un subsistema existente.
     *
     * @param id    el identificador del subsistema.
     * @param model el modelo que contiene el subsistema a editar.
     * @return la vista de edición si el subsistema existe, o redirección si no.
     */
    @GetMapping("/edit/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") int id, Model model) {
        Subsistema subsistema = subsistemaService.findById(id);
        if (subsistema != null) {
            model.addAttribute("subsistema", subsistema);
            return "editar-subsistema";
        } else {
            return "redirect:/subsistemas";
        }
    }

    /**
     * Actualiza un subsistema existente con los nuevos datos.
     *
     * @param subsistema el subsistema actualizado.
     * @return redirección a la lista de subsistemas.
     */
    @PostMapping("/update")
    public String actualizarSubsistema(@ModelAttribute Subsistema subsistema) {
        subsistemaService.save(subsistema);
        return "redirect:/subsistemas";
    }

    /**
     * Elimina un subsistema dado su identificador.
     *
     * @param id el identificador del subsistema a eliminar.
     * @return redirección a la lista de subsistemas.
     */
    @GetMapping("/delete/{id}")
    public String eliminarSubsistema(@PathVariable("id") int id) {
        subsistemaService.deleteById(id);
        return "redirect:/subsistemas";
    }
}