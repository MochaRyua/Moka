package com.bringup.bringup.domain.payload.Request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyPage {

    private String userId;

    private String userName;
}
