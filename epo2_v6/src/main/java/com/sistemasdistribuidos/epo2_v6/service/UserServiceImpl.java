package com.sistemasdistribuidos.epo2_v6.service;

import com.sistemasdistribuidos.epo2_v6.repository.UserRepository;
import com.sistemasdistribuidos.epo2_v6.model.User;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Implementación del servicio de usuarios.
 * Gestiona operaciones como guardar, buscar, validar y eliminar usuarios.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param userRepository el repositorio de usuarios.
     */
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Guarda o actualiza un usuario. Si no tiene rol, asigna "USER" por defecto.
     *
     * @param user el usuario a guardar.
     */
    @Override
    public void saveUser(User user) {
        if (user.getRole()==null) {
            user.setRole("USER");
        }
        userRepository.save(user);
    }

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username el nombre de usuario.
     * @return el usuario encontrado o null si no existe.
     */
    @Override
    public User getUserByUsername(String username) {

        return userRepository.findUsersByUsername(username);
    }

    /**
     * Valida si un usuario existe con el username y password dados.
     *
     * @param username el nombre de usuario.
     * @param password la contraseña.
     * @return el usuario si las credenciales coinciden, null si no.
     */
    @Override
    public User validateAuthentication(String username, String password) {
        if (username == null || password == null) {
            return null;
        }
        return userRepository.findUsersByUsernameAndPassword(username, password);
    }

    /**
     * Verifica si las credenciales proporcionadas son válidas.
     *
     * @param username el nombre de usuario.
     * @param password la contraseña.
     * @return true si son válidas, false si no.
     */
    @Override
        public boolean validateCredentials(String username, String password) {
            User user = userRepository.findUsersByUsername(username);
            return user != null && user.getPassword().equals(password);
        }
    /**
     * Busca un usuario por nombre de usuario (duplicado de getUserByUsername).
     *
     * @param username el nombre de usuario.
     * @return el usuario correspondiente o null.
     */
    @Override
        public User findByUsername(String username) {

        return userRepository.findUsersByUsername(username);
        }

    /**
     * Obtiene todos los usuarios registrados.
     *
     * @return lista de usuarios.
     */
    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    /**
     * Busca un usuario por su ID.
     *
     * @param id el identificador del usuario.
     * @return el usuario si se encuentra, o null.
     */
    @Override
    public User getUserById(Long id) {

        return userRepository.findById(id).orElse(null);
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param id el ID del usuario a eliminar.
     */
    @Override
    public void deleteUserById(Long id) {

        userRepository.deleteById(id);
    }
}
