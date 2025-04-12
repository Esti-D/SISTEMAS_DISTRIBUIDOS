package com.sistemasdistribuidos.epo2_v5.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistemasdistribuidos.epo2_v5.model.Documento;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @GetMapping("/cargadocs")
    public String mostrarFormulario() {
        return "cargadocs";
    }
    @PostMapping("/cargadocs")
    public String cargarDocumento(
            @RequestParam("file") MultipartFile file,
            @RequestParam("proyecto") String nombreProyecto,
            Model model) {

        try {
            // Preparar JSON con el nombre del archivo y del proyecto
            Map<String, String> jsonMap = new HashMap<>();
            jsonMap.put("nombre_doc", file.getOriginalFilename());
            jsonMap.put("nombre_pro", nombreProyecto);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonMap, headers);

            // Enviar a Flask
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://api-flask:5000/api/documentos";
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

            // Leer respuesta JSON de Flask
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> respuesta = mapper.readValue(response.getBody(), Map.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                model.addAttribute("mensaje", respuesta.get("mensaje"));
            } else {
                model.addAttribute("error", respuesta.get("error"));
            }

        } catch (Exception e) {
            model.addAttribute("error", "No se pudo conectar con Flask: " + e.getMessage());
        }

        return "cargadocs";
    }


}

