package com.sistemasdistribuidos.frontend.service;

import com.sistemasdistribuidos.frontend.model.Rol;
import com.sistemasdistribuidos.frontend.model.Usuario;
import com.sistemasdistribuidos.frontend.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsuarioServiceTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void testCrearUsuarioDePrueba() {
        // Dado (given)
        Usuario usuario = new Usuario("testuser", "test123", Rol.USUARIO);

        // Cuando (when)
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        // Entonces (then)
        assertNotNull(usuarioGuardado.getId(), "El usuario debe tener un ID tras guardarse");
        assertEquals("testuser", usuarioGuardado.getNombreUsuario());
        assertEquals(Rol.USUARIO, usuarioGuardado.getRol());

        // Limpieza después del test (opcional)
        usuarioRepository.delete(usuarioGuardado);
    }
}

