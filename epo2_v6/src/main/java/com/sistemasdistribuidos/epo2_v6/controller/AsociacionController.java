package com.sistemasdistribuidos.epo2_v6.controller;


import com.sistemasdistribuidos.epo2_v6.model.Asociacion;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Controlador encargado de mostrar la lista de asociaciones.
 * Se conecta con un microservicio propio (API Flask) para obtener los datos.
 */
@Controller
public class AsociacionController {

    /**
     * Recupera las asociaciones desde un microservicio Flask y las añade al modelo.
     *
     * @param model el modelo utilizado para pasar datos a la vista.
     * @return el nombre de la plantilla Thymeleaf "asociaciones".
     */
    @GetMapping("/asociaciones")
    public String mostrarAsociaciones(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api-flask:5000/api/asociaciones";

        ResponseEntity<Asociacion[]> response = restTemplate.getForEntity(url, Asociacion[].class);
        List<Asociacion> lista = Arrays.asList(response.getBody());

        model.addAttribute("asociaciones", lista);
        return "asociaciones";
    }
}

