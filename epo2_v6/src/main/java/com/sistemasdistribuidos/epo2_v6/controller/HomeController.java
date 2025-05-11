package com.sistemasdistribuidos.epo2_v6.controller;

import com.sistemasdistribuidos.epo2_v6.model.User;
import com.sistemasdistribuidos.epo2_v6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

/**
 * Controlador encargado de mostrar la vista principal de la aplicación
 * para usuarios autenticados.
 */
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    /**
     * Muestra la página principal (home) del sistema para el usuario autenticado.
     * Añade al modelo el usuario actual y la lista de todos los usuarios para funciones como el chat.
     * Si no hay sesión activa, redirige al login. Si el usuario no se encuentra, muestra una vista de error.
     *
     * @param model     el modelo utilizado para pasar datos a la vista.
     * @param principal el usuario autenticado actualmente.
     * @return el nombre de la plantilla "home", o una redirección al login o página de error.
     */
    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login?sessionExpired=true";
        }

        String username = principal.getName();
        User user = userService.findByUsername(username);

        if (user == null) {
            model.addAttribute("errorMessage", "No se encontró tu cuenta.");
            return "error-usuario";
        }

        model.addAttribute("usuario", user);
        model.addAttribute("usuarios", userService.getAllUsers());

        return "home";
    }
}
