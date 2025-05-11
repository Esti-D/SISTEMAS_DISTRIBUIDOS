package com.sistemasdistribuidos.epo2_v6.model;

/**
 * Representa una asociación entre un documento y un subsistema.
 * Esta clase se utiliza para vincular ambos elementos mediante sus identificadores.
 */

public class Asociacion {
    /** Identificador del documento asociado. */
    private int id_doc;
    /** Identificador del subsistema asociado. */
    private int id_sub;

    /**
     * Obtiene el ID del documento.
     *
     * @return el identificador del documento.
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
     * Obtiene el ID del subsistema.
     *
     * @return el identificador del subsistema.
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
}
