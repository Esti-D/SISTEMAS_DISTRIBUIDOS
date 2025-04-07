package com.sistemasdistribuidos.epo2_v5.service;


import com.sistemasdistribuidos.epo2_v5.model.User;

public interface UserService {
    void saveUser(User user);

    User getUserByUsername(String username);

    User validateAuthentication(String username, String password);

    public boolean validateCredentials(String username, String password);

    public User findByUsername(String username);

}
