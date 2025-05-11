package com.sistemasdistribuidos.epo2_v6.controller;

import com.sistemasdistribuidos.epo2_v6.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import com.sistemasdistribuidos.epo2_v6.model.User;
import com.sistemasdistribuidos.epo2_v6.service.UserService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


/**
 * Controlador encargado de realizar búsquedas de Pokémon a través de la API pública de PokeAPI.
 */
@Controller
public class PokemonController {

    @Autowired
    private UserService userService;
    /**
     * Busca un Pokémon por su nombre utilizando la API de PokeAPI.
     * Si se encuentra, añade su información (nombre, imagen, tipos) al modelo.
     * Si no se encuentra, añade un mensaje de error.
     *
     * @param nombre el nombre del Pokémon introducido por el usuario.
     * @param model  el modelo utilizado para pasar los datos del Pokémon o el error a la vista.
     * @return la plantilla "home" con el resultado de la búsqueda.
     */
    @GetMapping("/buscar-pokemon")
    public String buscarPokemon(@RequestParam("nombre") String nombre, Model model, Principal principal) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://pokeapi.co/api/v2/pokemon/" + nombre.toLowerCase();

        try {

            String username = principal.getName();
            User user = userService.findByUsername(username);
            model.addAttribute("usuario", user);
            model.addAttribute("usuarios", userService.getAllUsers());

            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            JSONObject json = new JSONObject(response.getBody());

            Pokemon pokemon = new Pokemon();
            pokemon.setNombre(json.getString("name"));
            pokemon.setImagenUrl(json.getJSONObject("sprites").getString("front_default"));

            JSONArray tiposArray = json.getJSONArray("types");
            List<String> tipos = new ArrayList<>();
            for (int i = 0; i < tiposArray.length(); i++) {
                tipos.add(tiposArray.getJSONObject(i).getJSONObject("type").getString("name"));
            }
            pokemon.setTipos(tipos);

            model.addAttribute("pokemon", pokemon);
        } catch (Exception e) {
            model.addAttribute("error", "No se encontró el Pokémon.");
        }

        return "home";  // Devuelve a la página principal con el resultado
    }
}
