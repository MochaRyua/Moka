package com.bringup.bringup.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Builder
@Entity
public class UserEntity {

    @Id
    @GeneratedValue
    private Integer uuid;

    @NotBlank
    private String userId;

    @NotBlank
    private String userPw;

    @NotBlank
    private String userName;


}
