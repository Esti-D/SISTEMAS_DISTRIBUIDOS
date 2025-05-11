package com.sistemasdistribuidos.epo2_v6.controller;

import com.sistemasdistribuidos.epo2_v6.model.User;
import com.sistemasdistribuidos.epo2_v6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador encargado de gestionar las operaciones CRUD sobre usuarios desde el panel de administración.
 */
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UserService userService;

    /**
     * Muestra la lista de todos los usuarios registrados.
     *
     * @param model el modelo utilizado para pasar la lista a la vista.
     * @return el nombre de la vista "usuarios".
     */
    @GetMapping
    public String listarUsuarios(Model model) {
        List<User> lista = userService.getAllUsers();
        model.addAttribute("usuarios", lista);
        return "usuarios";
    }

    /**
     * Guarda un nuevo usuario desde el formulario de creación.
     *
     * @param user el usuario a guardar.
     * @return redirección a la lista de usuarios.
     */
    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/usuarios";
    }

    /**
     * Muestra el formulario para editar un usuario existente.
     *
     * @param id    el ID del usuario a editar.
     * @param model el modelo que contiene el usuario a modificar.
     * @return la vista de edición si se encuentra el usuario, o redirección si no.
     */
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        if (user != null) {
            model.addAttribute("usuario", user);
            return "editar-usuario";
        }
        return "redirect:/usuarios";
    }

    /**
     * Actualiza un usuario existente con los datos enviados desde el formulario.
     *
     * @param user el usuario con los datos actualizados.
     * @return redirección a la lista de usuarios.
     */
    @PostMapping("/actualizar")
    public String actualizarUsuario(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/usuarios";
    }

    /**
     * Elimina un usuario dado su ID.
     *
     * @param id el ID del usuario a eliminar.
     * @return redirección a la lista de usuarios.
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/usuarios";
    }

    /**
     * Muestra el formulario para crear un nuevo usuario.
     *
     * @param model el modelo que contiene un nuevo objeto User vacío.
     * @return el nombre de la vista "crear-usuario".
     */
    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("usuario", new User());
        return "crear-usuario";
    }
}
