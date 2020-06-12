package com.bringup.bringup.service.user;

import com.bringup.bringup.domain.payload.request.user.SignInRequest;
import com.bringup.bringup.domain.payload.response.TokenResponse;

public interface AuthService {
    public TokenResponse SignIn(SignInRequest signIn);
    TokenResponse refreshToken(String token);
}
