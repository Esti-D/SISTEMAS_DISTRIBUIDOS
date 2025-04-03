
package com.sistemasdistribuidos.epo2_v3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

@GetMapping("/")
    public String index() {
        return "index"; // busca index.html en templates
    }
}
