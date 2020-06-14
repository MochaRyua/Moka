package com.bringup.bringup.domain.repository;

import com.bringup.bringup.domain.entity.PostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostsEntity, Integer> {
}
