package com.bringup.bringup.domain.payload.request.post;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class PostList {

    private String title;

    private String author;

    private LocalDateTime createDate;

    private LocalDateTime lastModifiedDate;
}
