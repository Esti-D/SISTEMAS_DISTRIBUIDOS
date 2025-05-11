package com.sistemasdistribuidos.epo2_v6.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Clase encargada de gestionar excepciones globales en la aplicación.
 * Proporciona vistas personalizadas para errores específicos como
 * fallos al consultar la API de Pokémon o errores inesperados.
 */
@ControllerAdvice
public class ErrorHandler {

    /**
     * Maneja errores cuando la API externa devuelve un 404 (por ejemplo, Pokémon no encontrado).
     *
     * @param model el modelo que se usará para pasar el mensaje de error a la vista.
     * @return el nombre de la vista de error personalizada para Pokémon.
     */
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public String pokemonNoEncontrado(Model model) {
        model.addAttribute("errorMessage", "No se encontró el Pokémon solicitado.");
        return "error-pokemon";
    }
    /**
     * Maneja errores generales no controlados específicamente en la aplicación.
     *
     * @param model el modelo que se usará para mostrar un mensaje genérico.
     * @return el nombre de la vista de error general.
     */
    @ExceptionHandler(Exception.class)
    public String errorGeneral(Model model) {
        model.addAttribute("errorMessage", "Ha ocurrido un error inesperado.");
        return "error";
    }
}
