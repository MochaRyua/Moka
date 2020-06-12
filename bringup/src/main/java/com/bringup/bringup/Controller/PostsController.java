package com.bringup.bringup.Controller;

import com.bringup.bringup.domain.payload.request.post.PostList;
import com.bringup.bringup.domain.payload.request.post.Posts;
import com.bringup.bringup.service.allposts.PostsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("post")
public class PostsController {

    private final PostsServiceImpl postsService;

    @GetMapping("list")
    public List<PostList> PostsList(@RequestHeader("Authorization") String token) {
        return postsService.postList(token);
    }

    @PostMapping("write")
    public void savePost(@RequestHeader("Authorization") String token, @RequestBody Posts posts) {

        postsService.savePost(token, posts);
    }
}
