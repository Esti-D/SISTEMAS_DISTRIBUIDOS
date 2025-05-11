package com.sistemasdistribuidos.epo2_v6.service;

import com.sistemasdistribuidos.epo2_v6.model.Proyecto;
import com.sistemasdistribuidos.epo2_v6.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio para la gestión de proyectos.
 * Utiliza ProyectoRepository para realizar operaciones CRUD sobre la base de datos.
 */
@Service
public class ProyectoServiceImpl implements ProyectoService {

    private final ProyectoRepository proyectoRepository;

    /**
     * Constructor que inyecta el repositorio de proyectos.
     *
     * @param proyectoRepository el repositorio de proyectos.
     */
    public ProyectoServiceImpl(ProyectoRepository proyectoRepository) {

        this.proyectoRepository = proyectoRepository;
    }

    /**
     * Devuelve la lista completa de proyectos.
     *
     * @return lista de proyectos.
     */
    @Override
    public List<Proyecto> findAll() {

        return proyectoRepository.findAll();
    }

    /**
     * Busca un proyecto por su identificador.
     *
     * @param id el ID del proyecto.
     * @return el proyecto correspondiente, o null si no se encuentra.
     */
    @Override
    public Proyecto findById(int id) {

        return proyectoRepository.findById(id).orElse(null);
    }

    /**
     * Guarda un nuevo proyecto o actualiza uno existente.
     *
     * @param proyecto el proyecto a guardar.
     * @return el proyecto guardado.
     */
    @Override
    public Proyecto save(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    /**
     * Elimina un proyecto dado su ID.
     *
     * @param id el ID del proyecto a eliminar.
     */
    @Override
    public void deleteById(int id) {
        proyectoRepository.deleteById(id);
    }
}

