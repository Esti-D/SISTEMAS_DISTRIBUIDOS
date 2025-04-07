package com.sistemasdistribuidos.epo2_v5.model;

import java.util.List;

public class Pokemon {
    private String nombre;
    private String imagenUrl;
    private List<String> tipos;

    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }
    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public List<String> getTipos() {
        return tipos;
    }
    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
    }
}

