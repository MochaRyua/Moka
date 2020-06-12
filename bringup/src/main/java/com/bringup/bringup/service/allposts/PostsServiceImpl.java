package com.bringup.bringup.service.allposts;

import com.bringup.bringup.domain.entity.PostsEntity;
import com.bringup.bringup.domain.entity.UserEntity;
import com.bringup.bringup.domain.payload.request.post.PostList;
import com.bringup.bringup.domain.payload.request.post.Posts;
import com.bringup.bringup.domain.repository.PostRepository;
import com.bringup.bringup.domain.repository.UserRepository;
import com.bringup.bringup.exxeption.UserNotFoundException;
import com.bringup.bringup.service.token.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostsServiceImpl implements PostsService {

    private final PostRepository repository;
    private final TokenService tokenService;
    private final UserRepository userRepository;

    @Override
    public void savePost(String token, Posts posts) {

        int uuid = tokenService.parseToken(token);
        UserEntity user = userRepository.findById(uuid).orElseThrow(UserNotFoundException::new);

        repository.save(
                PostsEntity.builder()
                .title(posts.getTitle())
                .content(posts.getContent())
                .author(user.getUserName())
                .build()
        );
    }

    @Override
    public List<PostList> postList(String token) {

        int uuid = tokenService.parseToken(token);
        UserEntity user = userRepository.findById(uuid).orElseThrow(UserNotFoundException::new);

        List<PostList> list = new ArrayList<>();

        List<PostsEntity> post = repository.findAll();

        for (PostsEntity postsEntity : post) {
            list.add(
                PostList.builder()
                    .title(postsEntity.getTitle())
                    .author(postsEntity.getAuthor())
                    .createDate(postsEntity.getCreatedDate())
                    .lastModifiedDate(postsEntity.getLastModifiedDate())
                    .build()
            );
        }

        return list;
    }
}
