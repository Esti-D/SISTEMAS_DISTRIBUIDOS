package com.sistemasdistribuidos.epo2_v6.model;

import jakarta.persistence.*;

/**
 * Entidad que representa un proyecto dentro del sistema.
 * Cada proyecto tiene un identificador único y un nombre único.
 */
@Entity
@Table(name = "proyectos")
public class Proyecto {
    /** Identificador único del proyecto (clave primaria). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pro;
    /** Nombre del proyecto, debe ser único y no nulo. */
    @Column(nullable = false, unique = true)
    private String nombre_pro;

    /**
     * Obtiene el ID del proyecto.
     *
     * @return el ID del proyecto.
     */
    public int getId_pro() {

        return id_pro;
    }
    /**
     * Establece el ID del proyecto.
     *
     * @param id_pro el nuevo ID del proyecto.
     */
    public void setId_pro(int id_pro) {

        this.id_pro = id_pro;
    }

    /**
     * Obtiene el nombre del proyecto.
     *
     * @return el nombre del proyecto.
     */
    public String getNombre_pro() {

        return nombre_pro;
    }

    /**
     * Establece el nombre del proyecto.
     *
     * @param nombre_pro el nuevo nombre del proyecto.
     */
    public void setNombre_pro(String nombre_pro) {

        this.nombre_pro = nombre_pro;
    }

}
