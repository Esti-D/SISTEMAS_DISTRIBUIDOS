package com.sistemasdistribuidos.epo2_v5.controller;


import com.sistemasdistribuidos.epo2_v5.model.Asociacion;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class AsociacionController {

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

