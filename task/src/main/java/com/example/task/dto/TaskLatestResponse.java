package com.example.task.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TaskLatestResponse {

    private Long taskId;
    private String content;

}
