package ru.yandex.practicum.catsgram.service;

import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.exceptions.InvalidEmailException;
import ru.yandex.practicum.catsgram.exceptions.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
    private final HashMap<String, User> users = new HashMap<>();

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public User create(User user) {
        String userEmail = user.getEmail();
        if (userEmail == null || userEmail.isBlank() || !userEmail.contains("@")) {
            throw new InvalidEmailException("Адрес электронной почты не может быть пустым.");
        }
        if (users.putIfAbsent(userEmail, user) == null) return user;
        throw new UserAlreadyExistException("Пользователь с электронной почтой " + user.getEmail() + " уже зарегистрирован.");
    }

    public User update(User user) {
        if (users.replace(user.getEmail(), user) == null) { // ключа нет в мапе -> нельзя обновить
            throw new UserAlreadyExistException("Пользователь с электронной почтой " + user.getEmail() + " не найден.");
        }
        return user;
    }

    public User findUserByEmail(String email) {
        return users.get(email);
    }
}
