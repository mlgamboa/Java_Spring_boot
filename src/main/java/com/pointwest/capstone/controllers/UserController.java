package com.pointwest.capstone.controllers;

import com.pointwest.capstone.models.User;
import com.pointwest.capstone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    // Creating a user
    @RequestMapping(value = "users/create", method = RequestMethod.POST)
    public ResponseEntity<Object> createUsers(@RequestBody User user){
        return userService.createUser(user);
    }


    // Retrieve all users
    @RequestMapping(value = "users/get-all", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
