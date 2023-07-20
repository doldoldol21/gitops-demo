package com.example.task.service;

import com.example.task.dto.TaskLatestResponse;
import com.example.task.dto.TaskSaveRequest;
import com.example.task.dto.TaskSaveResponse;
import com.example.task.entity.Task;
import com.example.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskLatestResponse latest(Long userId) {
        Task task = taskRepository.findFirstByUserIdOrderByTaskIdDesc(userId).orElse(null);
        if (Objects.isNull(task)) {
            return null;
        }
        return TaskLatestResponse.builder()
                .taskId(task.getTaskId())
                .content(task.getContent())
                .build();
    }

    public TaskSaveResponse save(TaskSaveRequest request) {
        Task task = Task.builder()
                .userId(request.getUserId())
                .content(request.getContent())
                .build();
        Task saveTask = taskRepository.save(task);
        return TaskSaveResponse.builder()
                .taskId(saveTask.getTaskId())
                .userId(saveTask.getUserId())
                .content(saveTask.getContent())
                .build();
    }
}
