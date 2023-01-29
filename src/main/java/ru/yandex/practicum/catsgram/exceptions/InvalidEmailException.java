package ru.yandex.practicum.catsgram.exceptions;

public class InvalidEmailException extends RuntimeException {

    public InvalidEmailException(String userEmail)  {
        super(String.format("invalid user email: %s", userEmail));
    }
}
