package com.bringup.bringup.service.user;

import com.bringup.bringup.domain.payload.request.user.MyPage;
import com.bringup.bringup.domain.payload.request.user.SignUpRequest;
import com.bringup.bringup.domain.payload.request.user.UserPw;

import java.util.List;

public interface UserService {

    public void SignUp(SignUpRequest signUpRequest);
    public void changPw(String token, UserPw userPw);
    public List<MyPage> pageList(String token);
}
