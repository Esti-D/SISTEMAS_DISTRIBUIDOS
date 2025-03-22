package com.sistemasdistribuidos.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ApiTestController {

    @GetMapping("/api-test")
    public String mostrarFormulario() {
        return "api-test";
    }

    @PostMapping("/api-test")
    public String procesarFormulario(
            @RequestParam String parametro,
            Model model
    ) {
        try {
            //  Aquí luego llamamos a la API Flask
            // De momento solo simulamos una respuesta
            String respuestaSimulada = "Llamada a la API con parámetro: " + parametro;

            model.addAttribute("resultado", respuestaSimulada);
        } catch (Exception e) {
            model.addAttribute("error", "Error al llamar a la API: " + e.getMessage());
        }

        return "api-test";
    }
}
