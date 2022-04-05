package ru.yandex.practicum.catsgram.exception;

public class InvalidEmailException extends RuntimeException {

    public InvalidEmailException(String userEmail)  {
        super(String.format("invalid user email: %s", userEmail));
    }
}
