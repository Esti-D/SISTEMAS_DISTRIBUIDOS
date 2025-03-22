package com.sistemasdistribuidos.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String mostrarInicio() {
        return "index"; // busca index.html en /resources/templates
    }
}