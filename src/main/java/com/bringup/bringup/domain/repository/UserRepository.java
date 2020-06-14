package com.bringup.bringup.domain.repository;

import com.bringup.bringup.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    boolean existsByUserId(String userId);
    //UserEntity findByRefreshToken(String token);
}
