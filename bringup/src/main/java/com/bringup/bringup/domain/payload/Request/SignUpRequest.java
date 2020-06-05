package com.bringup.bringup.domain.payload.Request;

import lombok.Data;

@Data
public class SignUpRequest {

    private String userId;

    private String userPw;

    private String userName;
}
