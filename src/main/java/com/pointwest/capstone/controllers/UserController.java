package com.pointwest.capstone.controllers;

import com.pointwest.capstone.exceptions.UserException;
import com.pointwest.capstone.models.User;
import com.pointwest.capstone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

     // Creating a user
    @RequestMapping(value = "users/create", method = RequestMethod.POST)
    public ResponseEntity<Object> createUsers(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<>("User successfully created",HttpStatus.CREATED);
    }

    // Retrieve all users
    @RequestMapping(value = "users/get-all", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    // User Registration
    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public ResponseEntity<Object> register(@RequestBody Map<String, String> body) throws UserException {
        String username = body.get("username");
        if(!userService.findByUsername(username).isEmpty()){
            throw new UserException("Username already exists");
        } else {
            String password = body.get("password");
            String encodedPassword = new BCryptPasswordEncoder().encode(password);
            String email = body.get("email");
            String phoneNumber = body.get("phoneNumber");

            User newUser = new User(username, encodedPassword, email, phoneNumber);
            userService.createUser(newUser);
            return new ResponseEntity<>("User registration successful", HttpStatus.CREATED);
        }
    }
}
