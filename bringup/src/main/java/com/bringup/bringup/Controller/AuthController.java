package com.bringup.bringup.Controller;


import com.bringup.bringup.domain.payload.Request.SignInRequest;
import com.bringup.bringup.domain.payload.response.TokenResponse;
import com.bringup.bringup.service.user.AuthServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthServiceImpl service;

    @PostMapping
    public TokenResponse signIn(@RequestBody SignInRequest sign) {

        return service.SignIn(sign);
    }

    @PutMapping
    public TokenResponse refreshToken(@RequestHeader("Authorization") String refreshToken) {

        return service.refreshToken(refreshToken);
    }
}
