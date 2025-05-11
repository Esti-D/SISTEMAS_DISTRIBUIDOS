package com.sistemasdistribuidos.epo2_v6.model;


import jakarta.persistence.*;

import java.security.Principal;

/**
 * Representa un usuario del sistema.
 * Implementa {@link Principal} para integrarse con la autenticación de Spring Security.
 */
@Entity
@Table(name= "user")
public class User implements Principal {
    /** Identificador único del usuario. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre de usuario utilizado para iniciar sesión. */
    @Column
    private String username;

    /** Contraseña del usuario. */
    @Column
    private String password;

    /** Rol del usuario (por ejemplo: "USER", "ADMIN"). */
    @Column (nullable = false)
    private String role;

    /** Constructor por defecto requerido por JPA. */
    public User(){

    }
    /**
     * Constructor con todos los campos.
     *
     * @param username nombre de usuario.
     * @param password contraseña del usuario.
     * @param role rol asignado al usuario.
     */
    public User (String username, String password, String role){
        super();
        this.username=username;
        this.password=password;
        this.role=role;
    }

    /**
     * Devuelve el nombre del usuario, requerido por {@link Principal}.
     *
     * @return el nombre de usuario.
     */
    public String getName(){

        return this.username;
    }
    /** @return el ID del usuario. */
    public Long getId() {

        return id;
    }

    /** @param id nuevo ID del usuario. */
    public void setId(Long id) {

        this.id = id;
    }

    /** @return el nombre de usuario. */
    public String getUsername() {

        return username;
    }

    /** @param username nuevo nombre de usuario. */
    public void setUsername(String username) {

        this.username = username;
    }

    /** @return la contraseña del usuario. */
    public String getPassword() {

        return password;
    }

    /** @param password nueva contraseña del usuario. */
    public void setPassword(String password) {

        this.password = password;
    }

    /** @return el rol del usuario. */
    public String getRole() {

        return role;
    }

    /** @param role nuevo rol del usuario. */
    public void setRole(String role) {

        this.role = role;
    }

    /** @return representación en texto del usuario. */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
