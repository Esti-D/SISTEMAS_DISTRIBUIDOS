package com.sistemasdistribuidos.epo2_v6.service;

import com.sistemasdistribuidos.epo2_v6.model.Proyecto;

import java.util.List;

/**
 * Interfaz para la capa de servicio relacionada con la entidad Proyecto.
 * Define las operaciones básicas CRUD que deben implementarse.
 */
public interface ProyectoService {
    /**
     * Obtiene todos los proyectos almacenados.
     *
     * @return una lista de todos los proyectos.
     */
    List<Proyecto> findAll();

    /**
     * Busca un proyecto por su identificador.
     *
     * @param id el ID del proyecto.
     * @return el proyecto correspondiente o null si no se encuentra.
     */
    Proyecto findById(int id);

    /**
     * Guarda un nuevo proyecto o actualiza uno existente.
     *
     * @param proyecto el proyecto a guardar o actualizar.
     * @return el proyecto guardado.
     */
    Proyecto save(Proyecto proyecto);

    /**
     * Elimina un proyecto por su identificador.
     *
     * @param id el ID del proyecto a eliminar.
     */
    void deleteById(int id);
}