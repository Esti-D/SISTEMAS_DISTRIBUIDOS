package com.sistemasdistribuidos.epo2_v6.controller;

import com.sistemasdistribuidos.epo2_v6.model.User;
import com.sistemasdistribuidos.epo2_v6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador encargado de gestionar el acceso de usuarios: login y registro.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Muestra el formulario de inicio de sesión.
     *
     * @return el nombre de la vista "login".
     */
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Muestra login.html
    }

    /**
     * Muestra el formulario de registro de nuevos usuarios.
     *
     * @param model el modelo que contiene el objeto User vacío para el formulario.
     * @return el nombre de la vista "registro".
     */
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("usuario", new User());
        return "registro"; // apunte a registro.html
    }

    /**
     * Procesa el registro de un nuevo usuario.
     * Verifica si el nombre de usuario ya existe antes de guardar.
     *
     * @param user  el usuario recibido desde el formulario.
     * @param model el modelo para mostrar mensajes de error o éxito.
     * @return redirección al login si el registro es exitoso, o vuelve al formulario si hay error.
     */
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("usuario") User user, Model model) {
        // Si ya existe, mostrar error
        if (userService.getUserByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "El usuario ya existe.");
            return "registro";
        }
        // Guardar con rol por defecto
        user.setRole("USER");
        userService.saveUser(user);
        return "redirect:/login";
    }
}