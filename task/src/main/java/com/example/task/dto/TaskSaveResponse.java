package com.example.task.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TaskSaveResponse {

    private Long taskId;
    private Long userId;
    private String content;
}
