package org.web.restapi.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(long id) {
        super(String.format("User with Id %d not found", id));
    }
}
