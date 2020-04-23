package com.journaly.journaly.controller;

import com.journaly.journaly.model.User;
import com.journaly.journaly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "*")
    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/sign-in")
    @ResponseStatus(HttpStatus.OK)
    public boolean authenticateUser(@Valid @RequestBody User user) {
        List<User> foundUser = userRepository.findByUsername(user.getUsername());
        return foundUser.size() != 0 ? true : false;
    }



}
