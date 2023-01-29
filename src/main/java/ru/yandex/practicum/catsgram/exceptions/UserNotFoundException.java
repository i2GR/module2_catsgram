package ru.yandex.practicum.catsgram.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String userEmail)  {
        super(String.format("Пользователь %s не найден", userEmail));
    }
}
