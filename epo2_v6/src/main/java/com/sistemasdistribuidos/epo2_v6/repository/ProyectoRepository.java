package com.sistemasdistribuidos.epo2_v6.repository;

import com.sistemasdistribuidos.epo2_v6.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para gestionar operaciones CRUD sobre la entidad {@link Proyecto}.
 *
 * Hereda de {@link JpaRepository} para proporcionar acceso a métodos como guardar,
 * eliminar, buscar por ID, etc.
 *
 * Puedes añadir aquí métodos personalizados si necesitas consultas específicas.
 */
@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
    // Se pueden añadir métodos personalizados si se necesita
}

