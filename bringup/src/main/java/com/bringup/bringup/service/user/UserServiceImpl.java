package com.bringup.bringup.service.user;

import com.bringup.bringup.domain.entity.UserEntity;
import com.bringup.bringup.domain.payload.Request.MyPage;
import com.bringup.bringup.domain.payload.Request.SignUpRequest;
import com.bringup.bringup.domain.payload.Request.UserPw;
import com.bringup.bringup.domain.repository.UserRepository;
import com.bringup.bringup.exxeption.UserAlreadyExistsException;
import com.bringup.bringup.exxeption.UserNotFoundException;
import com.bringup.bringup.service.token.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final TokenService tokenService;

    @Override
    public void SignUp(SignUpRequest signUpRequest) {

        if(userRepository.existsByUserId(signUpRequest.getUserId())) throw new UserAlreadyExistsException();

        userRepository.save(
                UserEntity.builder()
                        .userId(signUpRequest.getUserId())
                        .userPw(signUpRequest.getUserPw())
                        .userName(signUpRequest.getUserName())
                        .build()
        );
    }

    @Override
    public void changPw(String token, UserPw userPw) {

        int uuid = tokenService.parseRefreshToken(token);
        UserEntity user = userRepository.findById(uuid).orElseThrow(UserNotFoundException::new);
        user.setUserPw(userPw.getUserPw());

        userRepository.save(user);
    }

    @Override
    public List<MyPage> pageList(String token) {

        int uuid = tokenService.parseToken(token);

        List<MyPage> list = new ArrayList<>();

        List<UserEntity> user = userRepository.findAll();

        for (UserEntity users : user) {
            list.add(
                    MyPage.builder()
                    .userId(users.getUserId())
                    .userName(users.getUserName())
                    .build()
            );
        }

        return list;
    }


}
