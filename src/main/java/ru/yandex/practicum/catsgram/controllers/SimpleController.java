package ru.yandex.practicum.catsgram.controllers;

import ch.qos.logback.classic.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    private final Logger log = LoggerFactory.getLogger(SimpleController.class);
    {
        ((ch.qos.logback.classic.Logger) log).setLevel(Level.DEBUG);
    }

    @GetMapping("/home")
    public String homePage() {
        log.debug("Получен запрос.");
        return "Котограм";
    }
}
