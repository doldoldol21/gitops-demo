package com.example.user.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserSaveResponse {

    private Long userId;
    private String name;
    private Integer age;
}
