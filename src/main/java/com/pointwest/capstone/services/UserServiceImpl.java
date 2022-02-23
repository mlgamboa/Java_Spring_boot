package com.pointwest.capstone.services;

import com.pointwest.capstone.models.User;
import com.pointwest.capstone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    // Creating a user
//    public ResponseEntity createUser(User user){
//        String message = "User created successfully";
//        HttpStatus status = HttpStatus.CREATED;
//        boolean isDuplicate = false;
//
//        for(User indivUser: userRepository.findAll()){
//            if(user.getUsername().equalsIgnoreCase(indivUser.getUsername())){
//                message = "Username already exists";
//                status = HttpStatus.CONFLICT;
//                isDuplicate = true;
//            }
//        }
//        if(!isDuplicate){
//            userRepository.save(user);
//        }
//        return new ResponseEntity(message, status);
//    }

    public void createUser(User user){
        userRepository.save(user);
    }


    // Retrieve all users
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }


    public Optional<User> findByUsername(String username){
        return Optional.ofNullable(userRepository.findByUsername(username));
    }
}
