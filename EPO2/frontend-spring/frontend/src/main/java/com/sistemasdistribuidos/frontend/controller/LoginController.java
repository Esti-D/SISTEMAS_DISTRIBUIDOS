package com.sistemasdistribuidos.frontend.controller;

import com.sistemasdistribuidos.frontend.model.Activo;
import com.sistemasdistribuidos.frontend.model.Usuario;
import com.sistemasdistribuidos.frontend.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String autenticarUsuario(@RequestParam String nombreUsuario,
                                    @RequestParam String contraseña,
                                    HttpSession session,
                                    Model model) {

        Optional<Usuario> usuarioOpt = usuarioRepository.findByNombreUsuario(nombreUsuario);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            if (usuario.getContraseña().equals(contraseña)) {
                Activo activo = new Activo(usuario);
                session.setAttribute("activo", activo);

                return switch (activo.getRol()) {
                    case ADMIN -> "redirect:/admin/home";
                    case USUARIO -> "redirect:/usuario/home";
                    case SUPERVISOR -> "redirect:/supervisor/home";
                    default -> "redirect:/";
                };
            }
        }

        model.addAttribute("error", "Credenciales incorrectas, inténtelo de nuevo.");
        return "login";
    }

    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}


