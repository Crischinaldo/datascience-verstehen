package org.web.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.web.restapi.exception.UserNotFoundException;
import org.web.restapi.model.User;
import org.web.restapi.repository.UserRepository;
import org.web.restapi.specification.UserSpecifications;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<User> getUsers(){
        return userRepository.findAll();
    }


    public User getUserById(Long id) throws UserNotFoundException {
        return userRepository.findOne(UserSpecifications.getUserByID(id))
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not Found"));
    }

    public User add(@RequestBody User user) {
        return userRepository.save(user);
    }
}
