package ru.yandex.practicum.catsgram.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.model.exUser;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{login}")
    public Optional<User> getUser(@PathVariable String login){
        return userService.findUserById(login);
    }

   /* @GetMapping
    public Collection<exUser> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public exUser createUser(@RequestBody exUser user) {
        return userService.createUser(user);
    }

    @PutMapping
    public exUser updateUser(@RequestBody exUser user) {
        return userService.updateUser(user);
    }

    @GetMapping("/user/{userMail}")
    public exUser getUser(@PathVariable("userMail") String userMail){
        return userService.findUserByEmail(userMail);
    }*/
}
