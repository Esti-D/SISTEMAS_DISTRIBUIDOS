package com.sistemasdistribuidos.epo2_v6.repository;

import com.sistemasdistribuidos.epo2_v6.model.Subsistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para realizar operaciones CRUD sobre la entidad {@link Subsistema}.
 *
 * Hereda de {@link JpaRepository} lo que proporciona acceso a los métodos de persistencia
 * básicos como guardar, buscar, actualizar y eliminar.
 */
@Repository
public interface SubsistemaRepository extends JpaRepository<Subsistema, Integer> {
    // Se pueden añadir métodos personalizados si se necesita
}

