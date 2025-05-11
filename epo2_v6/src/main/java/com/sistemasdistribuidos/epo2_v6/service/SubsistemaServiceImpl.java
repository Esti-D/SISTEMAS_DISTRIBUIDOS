package com.sistemasdistribuidos.epo2_v6.service;

import com.sistemasdistribuidos.epo2_v6.model.Subsistema;
import com.sistemasdistribuidos.epo2_v6.repository.SubsistemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación de la interfaz SubsistemaService.
 * Proporciona la lógica de negocio para gestionar entidades Subsistema.
 */
@Service
public class SubsistemaServiceImpl implements SubsistemaService {

    private final SubsistemaRepository subsistemaRepository;

    /**
     * Constructor que inyecta el repositorio de subsistemas.
     *
     * @param subsistemaRepository el repositorio para acceder a los datos de subsistemas.
     */
    public SubsistemaServiceImpl(SubsistemaRepository subsistemaRepository) {
        this.subsistemaRepository = subsistemaRepository;
    }

    /**
     * Obtiene todos los subsistemas de la base de datos.
     *
     * @return una lista de subsistemas.
     */
    @Override
    public List<Subsistema> findAll() {
        return subsistemaRepository.findAll();
    }

    /**
     * Busca un subsistema por su ID.
     *
     * @param id el ID del subsistema.
     * @return el subsistema si existe, o null si no se encuentra.
     */
    @Override
    public Subsistema findById(int id) {
        return subsistemaRepository.findById(id).orElse(null);
    }

    /**
     * Guarda o actualiza un subsistema en la base de datos.
     *
     * @param subsistema el subsistema a guardar.
     * @return el subsistema guardado.
     */
    @Override
    public Subsistema save(Subsistema subsistema) {
        return subsistemaRepository.save(subsistema);
    }

    /**
     * Elimina un subsistema por su ID.
     *
     * @param id el ID del subsistema a eliminar.
     */
    @Override
    public void deleteById(int id) {
        subsistemaRepository.deleteById(id);
    }
}

