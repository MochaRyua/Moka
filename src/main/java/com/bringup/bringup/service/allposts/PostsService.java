package com.bringup.bringup.service.allposts;

import com.bringup.bringup.domain.payload.request.post.PostList;
import com.bringup.bringup.domain.payload.request.post.Posts;

import java.util.List;

public interface PostsService {

    public void savePost(String token, Posts posts);
    public List<PostList> postList(String token);
}
