package com.sistemasdistribuidos.epo2_v5.model;

public class Documento {
    private int id_doc;
    private String nombre_doc;
    private int id_pro; // faltaba este

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


