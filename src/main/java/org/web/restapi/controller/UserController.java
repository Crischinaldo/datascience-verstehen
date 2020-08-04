package org.web.restapi.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.web.restapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.web.restapi.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/users"
    )
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/users",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

}
