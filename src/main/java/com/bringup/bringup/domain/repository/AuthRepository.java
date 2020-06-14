package com.bringup.bringup.domain.repository;

import com.bringup.bringup.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserIdAndUserPw(String userId, String userPw);
    UserEntity findByUuid(int uuid);
}
