package com.sistemasdistribuidos.epo2_v6.model;


import jakarta.persistence.*;

/**
 * Entidad que representa un documento asociado a un proyecto.
 * Almacena información básica como nombre del documento y el ID del proyecto al que pertenece.
 */
@Entity
@Table(name = "documentos")
public class Documento {

    /** Identificador único del documento (clave primaria). */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_doc;

    /** Nombre del documento (no puede ser nulo). */
    @Column(nullable = false)
    private String nombre_doc;

    /** Identificador del proyecto al que está asociado este documento. */
    @Column(name = "id_pro", nullable = false)
    private int id_pro; // solo el ID, sin el objeto Proyecto

    /**
     * Obtiene el ID del documento.
     *
     * @return el identificador único del documento.
     */
    public int getId_doc() {

        return id_doc;
    }
    /**
     * Establece el ID del documento.
     *
     * @param id_doc el nuevo ID del documento.
     */
    public void setId_doc(int id_doc) {

        this.id_doc = id_doc;
    }
    /**
     * Obtiene el nombre del documento.
     *
     * @return el nombre del documento.
     */
    public String getNombre_doc() {

        return nombre_doc;
    }
    /**
     * Establece el nombre del documento.
     *
     * @param nombre_doc el nuevo nombre del documento.
     */
    public void setNombre_doc(String nombre_doc) {

        this.nombre_doc = nombre_doc;
    }
    /**
     * Obtiene el ID del proyecto al que pertenece el documento.
     *
     * @return el ID del proyecto asociado.
     */
    public int getId_pro() {

        return id_pro;
    }
    /**
     * Establece el ID del proyecto al que pertenece el documento.
     *
     * @param id_pro el ID del proyecto asociado.
     */
    public void setId_pro(int id_pro) {

        this.id_pro = id_pro;
    }
}



