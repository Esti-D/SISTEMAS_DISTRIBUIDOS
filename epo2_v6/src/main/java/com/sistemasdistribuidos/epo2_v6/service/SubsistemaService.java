package com.sistemasdistribuidos.epo2_v6.service;

import com.sistemasdistribuidos.epo2_v6.model.Subsistema;

import java.util.List;

/**
 * Interfaz de servicio para la gestión de subsistemas.
 * Define las operaciones básicas de acceso y manipulación de datos de subsistemas.
 */
public interface SubsistemaService {
    /**
     * Obtiene todos los subsistemas almacenados.
     *
     * @return una lista de todos los subsistemas.
     */
    List<Subsistema> findAll();

    /**
     * Busca un subsistema por su identificador.
     *
     * @param id el ID del subsistema.
     * @return el subsistema correspondiente o null si no se encuentra.
     */
    Subsistema findById(int id);

    /**
     * Guarda un nuevo subsistema o actualiza uno existente.
     *
     * @param subsistema el subsistema a guardar.
     * @return el subsistema guardado.
     */
    Subsistema save(Subsistema subsistema);

    /**
     * Elimina un subsistema dado su identificador.
     *
     * @param id el ID del subsistema a eliminar.
     */
    void deleteById(int id);
}

