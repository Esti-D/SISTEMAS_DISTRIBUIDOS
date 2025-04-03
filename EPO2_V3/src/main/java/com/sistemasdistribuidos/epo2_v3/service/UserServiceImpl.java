package com.sistemasdistribuidos.epo2_v3.service;

import com.sistemasdistribuidos.epo2_v3.repository.UserRepository;
import com.sistemasdistribuidos.epo2_v3.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUsersByUsername(username);
    }

    @Override
    public User validateAuthentication(String username, String password) {
        if (username == null || password == null) {
            return null;
        }
        return userRepository.findUsersByUsernameAndPassword(username, password);
    }
    @Override
        public boolean validateCredentials(String username, String password) {
            User user = userRepository.findUsersByUsername(username);
            return user != null && user.getPassword().equals(password);
        }
    @Override
        public User findByUsername(String username) {
            return userRepository.findUsersByUsername(username);
        }
}

