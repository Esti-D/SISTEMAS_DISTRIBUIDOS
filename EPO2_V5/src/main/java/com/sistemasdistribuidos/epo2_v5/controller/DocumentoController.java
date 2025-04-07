package com.sistemasdistribuidos.epo2_v5.controller;

import com.sistemasdistribuidos.epo2_v5.model.Documento;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class DocumentoController {

    @GetMapping("/documentos")
    public String mostrarDocumentos(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api-flask:5000/api/documentos";

        ResponseEntity<Documento[]> response = restTemplate.getForEntity(url, Documento[].class);
        List<Documento> lista = Arrays.asList(response.getBody());

        model.addAttribute("documentos", lista);
        return "documentos";
    }
}

