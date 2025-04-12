package com.sistemasdistribuidos.epo2_v5.controller;

import com.sistemasdistribuidos.epo2_v5.model.Proyecto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;


import java.util.Arrays;
import java.util.List;

@Controller
public class ProyectoController {

    @GetMapping("/proyectos")
    public String mostrarProyectos(Model model) {
        RestTemplate restTemplate = new RestTemplate();

        // URL del backend de Flask
        String url = "http://api-flask:5000/api/proyectos";

        // Llama a Flask y obtiene los datos
        ResponseEntity<Proyecto[]> response = restTemplate.getForEntity(url, Proyecto[].class);
        List<Proyecto> listaProyectos = Arrays.asList(response.getBody());

        // Pásalos al HTML
        model.addAttribute("proyectos", listaProyectos);
        return "proyectos"; // <- será tu HTML "proyectos.html"
    }
}
