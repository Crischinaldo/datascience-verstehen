package org.web.restapi.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.web.restapi.exception.UserNotFoundException;
import org.web.restapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.web.restapi.repository.UserRepository;
import org.web.restapi.service.UserService;
import org.web.restapi.specification.UserSpecifications;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/users"
    )
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/users/{id}"
    )
    public User getUserById(@PathVariable Long id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/users",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public User addUser(@RequestBody User user) {
        return userService.add(user);
    }

}
