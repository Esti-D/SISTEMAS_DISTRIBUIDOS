package com.sistemasdistribuidos.epo2_v5.controller;

import com.sistemasdistribuidos.epo2_v5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Muestra login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        boolean valid = userService.validateCredentials(username, password);

        if (valid) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Credenciales incorrectas.");
            return "login";
        }
    }
}

