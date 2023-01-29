package ru.yandex.practicum.catsgram.exceptions;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String userEmail){
        super(String.format("user with email: %s already exists", userEmail));
    }
}
