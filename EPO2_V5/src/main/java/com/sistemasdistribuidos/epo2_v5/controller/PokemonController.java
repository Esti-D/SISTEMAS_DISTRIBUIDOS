package com.sistemasdistribuidos.epo2_v5.controller;

import com.sistemasdistribuidos.epo2_v5.model.Pokemon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PokemonController {

    @GetMapping("/buscar-pokemon")
    public String buscarPokemon(@RequestParam("nombre") String nombre, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://pokeapi.co/api/v2/pokemon/" + nombre.toLowerCase();

        try {
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

