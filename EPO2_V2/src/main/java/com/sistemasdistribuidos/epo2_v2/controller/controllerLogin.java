package com.sistemasdistribuidos.epo2_v2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controllerLogin {


    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Redirige a la página de login
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Verificar las credenciales (esto puedes adaptarlo según tu lógica)
        if ("admin".equals(username) && "password".equals(password)) {
            model.addAttribute("username", username);
            return "home"; // Si el login es correcto, redirige a la página home
        } else {
            model.addAttribute("error", true); // Si las credenciales son incorrectas, muestra un mensaje de error
            return "login"; // Vuelve a mostrar la página de login
        }
    }
}
