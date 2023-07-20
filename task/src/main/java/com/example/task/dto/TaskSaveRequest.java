package com.example.task.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TaskSaveRequest {

    private Long userId;
    private String content;

}
