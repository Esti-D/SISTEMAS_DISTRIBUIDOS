package com.sistemasdistribuidos.epo2_v3.repository;

import com.sistemasdistribuidos.epo2_v3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    User findUsersByUsername(String username);

    User findUsersByUsernameAndPassword(String username, String password);


}
