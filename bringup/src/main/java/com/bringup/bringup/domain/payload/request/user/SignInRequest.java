package com.bringup.bringup.domain.payload.request.user;

import lombok.Data;

@Data
public class SignInRequest {

    private String userId;

    private String userPw;
}
