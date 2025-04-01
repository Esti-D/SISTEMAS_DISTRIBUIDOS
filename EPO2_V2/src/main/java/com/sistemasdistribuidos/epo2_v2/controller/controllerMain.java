package com.sistemasdistribuidos.epo2_v2.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class controllerMain {

    @GetMapping("/")
    public String home() {
        return "index";  // Nombre de la página HTML que vamos a crear
    }
}
