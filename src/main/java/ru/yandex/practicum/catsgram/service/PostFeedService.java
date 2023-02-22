
package ru.yandex.practicum.catsgram.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
@Service
public class PostFeedService {
    PostService postService;
    @Autowired
    public PostFeedService(PostService postService){
        this.postService = postService;
    }

    public List<Post> getFriendsFeed(String feed) {
        ObjectMapper objectMapper = new ObjectMapper();
        FriendFeed friendFeed;
        try {
            friendFeed = objectMapper.readValue(feed, FriendFeed.class);
        } catch (JsonProcessingException jpe) {
            return new ArrayList<>();
        }
        List<Post> posts = new ArrayList<>(postService.findPosts(0,friendFeed.getSorting(), friendFeed.getSize()));
        List<Post> responce = new ArrayList<>();
        for (String user : friendFeed.getFriends()) {
            responce.addAll(posts.stream().filter(p -> p.getAuthor().equals(user)).collect(Collectors.toList()));
        }
        return responce;
    }

    class FriendFeed {
        private String sorting;
        private int size;
        List<String> friends;

        public FriendFeed(String sorting, int size, List<String> friends) {
            this.sorting = sorting;
            this.size = size;
            this.friends = friends;
        }        ObjectMapper mapper = new ObjectMapper();

        public String getSorting() {
            return sorting;
        }

        public void setSorting(String sorting) {
            this.sorting = sorting;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public List<String> getFriends() {
            return friends;
        }

        public void setFriends(List<String> friends) {
            this.friends = friends;
        }
    }
}
*/
