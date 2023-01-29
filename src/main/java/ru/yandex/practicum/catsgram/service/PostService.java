package ru.yandex.practicum.catsgram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.exceptions.PostNotFoundException;
import ru.yandex.practicum.catsgram.exceptions.UserNotFoundException;
import ru.yandex.practicum.catsgram.model.Post;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final UserService userService;
    private static Integer postId = 0;
    private final List<Post> posts = new ArrayList<>();

    @Autowired
    public PostService(UserService userService) {
        this.userService = userService;
    }

    public Post create(Post post) {
        if (userService.findUserByEmail(post.getAuthor()) == null) throw new UserNotFoundException(post.getAuthor());
        post.setId(getNextId());
        posts.add(post);
        return post;
    }

    public List<Post> findPosts(int from, String sort,  int size) {
        List<Post> response = new ArrayList<>(posts);
        int ordering = getOrdering(sort);
        response.sort((post1, post2) -> post1.getCreationDate().isBefore(post2.getCreationDate()) ? ordering : -ordering);
        return response.subList(from, from + size - 1);
    }

    public Post getId(int id) {
        return posts.get(id);
    }

    public Post findPostById(Integer postId) {
        for (Post p : posts) {
            if (p.getId().equals(postId)) return p;
        }
        throw new PostNotFoundException(String.valueOf(postId));
    }

    private static Integer getNextId() {
        return postId++;
    }

     enum PostOrder {

        ASCENDING(1),
        DESCENDING(-1);
        private final int ordering;
        PostOrder(int ordering) {
            this.ordering = ordering;
        }

        public int getValue() {
            return ordering;
        }
    }

    private int getOrdering(String sort) {
        int ordering;
        try {
            ordering = PostOrder.valueOf(sort.toUpperCase() + "ENDING").getValue();
        } catch (IllegalArgumentException iae) {
            ordering = PostOrder.DESCENDING.getValue();
        }
        return ordering;
    }
}
