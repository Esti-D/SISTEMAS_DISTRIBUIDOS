package com.sistemasdistribuidos.epo2_v5.controller;

import com.sistemasdistribuidos.epo2_v5.model.Subsistema;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class SubsistemaController {

    @GetMapping("/subsistemas")
    public String mostrarSubsistemas(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api-flask:5000/api/subsistemas";

        ResponseEntity<Subsistema[]> response = restTemplate.getForEntity(url, Subsistema[].class);
        List<Subsistema> lista = Arrays.asList(response.getBody());

        model.addAttribute("subsistemas", lista);
        return "subsistemas";
    }
}

