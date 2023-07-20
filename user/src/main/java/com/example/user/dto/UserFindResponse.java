package com.example.user.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserFindResponse {

    private Long userId;
    private String name;
    private Integer age;
}
