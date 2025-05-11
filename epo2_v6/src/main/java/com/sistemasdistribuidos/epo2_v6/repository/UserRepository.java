package com.sistemasdistribuidos.epo2_v6.repository;

import com.sistemasdistribuidos.epo2_v6.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de acceso a datos para la entidad {@link User}.
 *
 * Proporciona métodos personalizados para encontrar usuarios por nombre de usuario
 * y para validar combinaciones de usuario y contraseña.
 */
@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username el nombre de usuario.
     * @return el usuario encontrado, o null si no existe.
     */
    User findUsersByUsername(String username);

    /**
     * Busca un usuario por su nombre de usuario y contraseña.
     *
     * @param username el nombre de usuario.
     * @param password la contraseña.
     * @return el usuario encontrado si coincide, o null si no existe.
     */
    User findUsersByUsernameAndPassword(String username, String password);


}
