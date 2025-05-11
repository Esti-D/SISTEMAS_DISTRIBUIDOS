package com.sistemasdistribuidos.epo2_v6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador encargado de mostrar un mapa según la ciudad proporcionada.
 */
@Controller
public class MapaController {

    /**
     * Muestra la vista del mapa centrado en la ciudad indicada por el usuario.
     *
     * @param ciudad el nombre de la ciudad que se desea visualizar.
     * @param model  el modelo utilizado para pasar la ciudad a la vista.
     * @return el nombre de la plantilla "mapa".
     */
    @GetMapping("/mapa")
    public String verMapa(@RequestParam String ciudad, Model model) {
        model.addAttribute("ciudad", ciudad);
        return "mapa"; // Busca mapa.html
    }
}
