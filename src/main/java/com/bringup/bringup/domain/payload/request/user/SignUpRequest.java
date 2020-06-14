package com.bringup.bringup.domain.payload.request.user;

import lombok.Data;

@Data
public class SignUpRequest {

    private String userId;

    private String userPw;

    private String userName;
}
