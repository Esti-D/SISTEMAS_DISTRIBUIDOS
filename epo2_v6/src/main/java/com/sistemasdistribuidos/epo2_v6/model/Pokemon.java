package com.sistemasdistribuidos.epo2_v6.model;

import java.util.List;

/**
 * Representa un Pokémon con su nombre, imagen y tipos asociados.
 * Esta clase es utilizada para mapear los datos obtenidos desde la API de PokeAPI.
 */
public class Pokemon {
    /** Nombre del Pokémon. */
    private String nombre;
    /** URL de la imagen del Pokémon. */
    private String imagenUrl;
    /** Lista de tipos del Pokémon (por ejemplo: fuego, agua, planta, etc.). */
    private List<String> tipos;

    /**
     * Obtiene el nombre del Pokémon.
     *
     * @return el nombre del Pokémon.
     */
    public String getNombre() {

        return nombre;
    }
    /**
     * Establece el nombre del Pokémon.
     *
     * @param nombre el nombre del Pokémon.
     */
    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    /**
     * Obtiene la URL de la imagen del Pokémon.
     *
     * @return la URL de la imagen.
     */
    public String getImagenUrl() {

        return imagenUrl;
    }
    /**
     * Establece la URL de la imagen del Pokémon.
     *
     * @param imagenUrl la URL de la imagen.
     */
    public void setImagenUrl(String imagenUrl) {

        this.imagenUrl = imagenUrl;
    }

    /**
     * Obtiene la lista de tipos del Pokémon.
     *
     * @return lista de tipos.
     */
    public List<String> getTipos() {

        return tipos;
    }
    /**
     * Establece la lista de tipos del Pokémon.
     *
     * @param tipos lista de tipos del Pokémon.
     */
    public void setTipos(List<String> tipos) {

        this.tipos = tipos;
    }
}

