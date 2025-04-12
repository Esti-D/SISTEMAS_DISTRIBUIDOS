package com.sistemasdistribuidos.epo2_v5.model;


import jakarta.persistence.*;

@Entity
@Table(name = "documentos")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_doc;

    @Column(nullable = false)
    private String nombre_doc;

    @Column(name = "id_pro", nullable = false)
    private int id_pro; // solo el ID, sin el objeto Proyecto

    // Getters y setters
    public int getId_doc() {
        return id_doc;
    }

    public void setId_doc(int id_doc) {
        this.id_doc = id_doc;
    }

    public String getNombre_doc() {
        return nombre_doc;
    }

    public void setNombre_doc(String nombre_doc) {
        this.nombre_doc = nombre_doc;
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }
}



