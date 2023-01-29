package ru.yandex.practicum.catsgram.exceptions;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(String postId)  {
        super(String.format("Пост %s не найден", postId));
    }
}
