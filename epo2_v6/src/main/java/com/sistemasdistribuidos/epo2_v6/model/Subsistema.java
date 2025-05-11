package com.sistemasdistribuidos.epo2_v6.model;

import jakarta.persistence.*;

/**
 * Entidad que representa un subsistema dentro de un proyecto.
 * Cada subsistema tiene un identificador único y un nombre obligatorio.
 */
@Entity
@Table(name = "subsistemas")
public class Subsistema {
    /** Identificador único del subsistema (clave primaria). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sub;
    /** Nombre del subsistema, obligatorio. */
    @Column(nullable = false)
    private String nombre_sub;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Subsistema() {}

    /**
     * Obtiene el ID del subsistema.
     *
     * @return el ID del subsistema.
     */
    public int getId_sub() {
        return id_sub;
    }

    /**
     * Establece el ID del subsistema.
     *
     * @param id_sub el nuevo ID del subsistema.
     */
    public void setId_sub(int id_sub) {

        this.id_sub = id_sub;
    }
    /**
     * Obtiene el nombre del subsistema.
     *
     * @return el nombre del subsistema.
     */
    public String getNombre_sub() {

        return nombre_sub;
    }
    /**
     * Establece el nombre del subsistema.
     *
     * @param nombre_sub el nuevo nombre del subsistema.
     */
    public void setNombre_sub(String nombre_sub) {

        this.nombre_sub = nombre_sub;
    }
}


