package com.sistemasdistribuidos.frontend.model;

public class Activo {

    private static int contadorActivos = 0;

    private final int idActivo;
    private final String usuario;
    private final String password;
    private final Rol rol;

    // Constructor actualizado correctamente
    public Activo(Usuario usuario) {
        this.usuario = usuario.getNombreUsuario();
        this.password = usuario.getContraseña();
        this.rol = usuario.getRol();
        this.idActivo = ++contadorActivos;
    }

    // getters útiles
    public int getIdActivo() {
        return idActivo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public Rol getRol() {
        return rol;
    }

    // método para validar roles fácilmente
    public boolean tieneRol(Rol rolBuscado) {
        return this.rol == rolBuscado;
    }
}


