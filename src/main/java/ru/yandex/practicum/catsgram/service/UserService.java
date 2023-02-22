package ru.yandex.practicum.catsgram.service;

import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.dao.UserDao;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.model.exUser;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Optional<User> findUserById(String id) {
        return userDao.findUserById(id);
    }
    private final Map<String, exUser> users = new HashMap<>();

    public Collection<exUser> findAll() {
        return users.values();
    }

    public exUser createUser(exUser user) {
        checkEmail(user);
        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistException(String.format(
                    "Пользователь с электронной почтой %s уже зарегистрирован.",
                    user.getEmail()
            ));
        }
        users.put(user.getEmail(), user);
        return user;
    }

    public exUser updateUser(exUser user) {
        checkEmail(user);
        users.put(user.getEmail(), user);

        return user;
    }

    public exUser findUserByEmail(String email) {
        if (email == null) {
            return null;
        }
        return users.get(email);
    }

    private void checkEmail(exUser user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Адрес электронной почты не может быть пустым.");
        }
    }
}