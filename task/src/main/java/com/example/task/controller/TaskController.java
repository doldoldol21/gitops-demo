package com.example.task.controller;

import com.example.task.dto.TaskLatestResponse;
import com.example.task.dto.TaskSaveRequest;
import com.example.task.dto.TaskSaveResponse;
import com.example.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/latest/{userId}")
    public ResponseEntity<TaskLatestResponse> latest(@PathVariable Long userId) {
        TaskLatestResponse response = taskService.latest(userId);
        if (Objects.isNull(response)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/")
    public ResponseEntity<TaskSaveResponse> save(@RequestBody TaskSaveRequest taskSaveRequest) {
        TaskSaveResponse response = taskService.save(taskSaveRequest);
        return ResponseEntity.ok(response);
    }
}
