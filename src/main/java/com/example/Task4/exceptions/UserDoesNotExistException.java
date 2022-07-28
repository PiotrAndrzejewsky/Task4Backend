package com.example.Task4.exceptions;

public class UserDoesNotExistException extends RuntimeException{
    public UserDoesNotExistException(String username) { super("There is no user with username " + username); }

    public UserDoesNotExistException(Long id) { super("There is no user with id " + id); }
}
