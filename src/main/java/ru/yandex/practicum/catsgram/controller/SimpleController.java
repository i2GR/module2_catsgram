package ru.yandex.practicum.catsgram.controller;

import ch.qos.logback.classic.Level;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.catsgram.service.HackCatService;

@RestController
@RequiredArgsConstructor
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

    private final HackCatService hackCatService;

    // внедрите бин HackCatService

    @GetMapping("/do-hack")
    public void doHack(){
        // хакните этих котиков
        hackCatService.doHackNow();
    }

}
