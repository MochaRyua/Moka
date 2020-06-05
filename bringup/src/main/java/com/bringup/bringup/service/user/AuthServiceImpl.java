package com.bringup.bringup.service.user;

import com.bringup.bringup.domain.entity.UserEntity;
import com.bringup.bringup.domain.payload.Request.SignInRequest;
import com.bringup.bringup.domain.payload.response.TokenResponse;
import com.bringup.bringup.domain.repository.AuthRepository;
import com.bringup.bringup.exxeption.UserNotFoundException;
import com.bringup.bringup.service.token.TokenServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final AuthRepository authRepository;
    private final TokenServiceImpl tokenService;

    @Override
    public TokenResponse SignIn(SignInRequest signIn) {

        UserEntity user = authRepository.findByUserIdAndUserPw(signIn.getUserId(), signIn.getUserPw());

        if (user == null) throw new UserNotFoundException();

        Integer uuid = user.getUuid();

        return TokenResponse.builder()
                .accessToken(tokenService.generateAccessToken(uuid))
                .refreshToken(tokenService.generateRefreshToken(uuid))
                .build();
    }

    @Override
    public TokenResponse refreshToken(String token) {

        int uuid = tokenService.parseRefreshToken(token);

        return TokenResponse.builder()
                .accessToken(tokenService.generateAccessToken(uuid))
                .refreshToken(tokenService.generateRefreshToken(uuid))
                .build();
    }
}
