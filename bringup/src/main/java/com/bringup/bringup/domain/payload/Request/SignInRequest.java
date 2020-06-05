package com.bringup.bringup.domain.payload.Request;

import lombok.Data;

@Data
public class SignInRequest {

    private String userId;

    private String userPw;
}
