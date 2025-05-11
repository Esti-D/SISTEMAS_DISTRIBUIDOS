package com.sistemasdistribuidos.epo2_v6.service;

import com.sistemasdistribuidos.epo2_v6.model.User;

import java.util.List;

/**
 * Interfaz que define las operaciones del servicio para gestionar usuarios.
 */
public interface UserService {
    /**
     * Guarda un nuevo usuario o actualiza uno existente.
     *
     * @param user el usuario a guardar.
     */
    void saveUser(User user);

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username el nombre de usuario a buscar.
     * @return el usuario encontrado o null si no existe.
     */
    User getUserByUsername(String username);

    /**
     * Valida las credenciales de autenticación.
     *
     * @param username el nombre de usuario.
     * @param password la contraseña del usuario.
     * @return el usuario si las credenciales son válidas, null en caso contrario.
     */
    User validateAuthentication(String username, String password);

    /**
     * Verifica si las credenciales del usuario son correctas.
     *
     * @param username el nombre de usuario.
     * @param password la contraseña.
     * @return true si las credenciales coinciden, false en caso contrario.
     */
    public boolean validateCredentials(String username, String password);

    /**
     * Busca un usuario por su nombre de usuario.
     * (Puede ser redundante con getUserByUsername).
     *
     * @param username el nombre de usuario.
     * @return el usuario encontrado o null.
     */
    public User findByUsername(String username);

    /**
     * Obtiene todos los usuarios registrados.
     *
     * @return una lista de todos los usuarios.
     */
    List<User> getAllUsers();

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id el ID del usuario.
     * @return el usuario correspondiente o null si no existe.
     */
    User getUserById(Long id);

    /**
     * Elimina un usuario por su ID.
     *
     * @param id el ID del usuario a eliminar.
     */
    void deleteUserById(Long id);

}
