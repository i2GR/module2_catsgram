package ru.yandex.practicum.catsgram.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.service.PostFeedService;

import java.util.List;

@RestController
public class PostFeedController {

    private PostFeedService postFeedService;

    @Autowired
    public PostFeedController(PostFeedService postFeedService) {
        this.postFeedService = postFeedService;
    }

    @PostMapping("/feed/friends")
    public List<Post> posts(@RequestBody String request) {

        return postFeedService.getFriendsFeed(request);
    }
}
