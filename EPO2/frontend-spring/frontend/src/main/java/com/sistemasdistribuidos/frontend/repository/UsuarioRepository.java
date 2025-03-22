package com.sistemasdistribuidos.frontend.repository;

import com.sistemasdistribuidos.frontend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar por nombre de usuario
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}

