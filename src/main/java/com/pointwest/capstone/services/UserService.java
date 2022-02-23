package com.pointwest.capstone.services;

import com.pointwest.capstone.models.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {

    // Create a user
    void createUser(User user);

    // Retrieve all user
    Iterable<User> getAllUsers();

    Optional<User> findByUsername(String username);

}
