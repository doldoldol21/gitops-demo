package com.example.user.controller;

import com.example.user.dto.UserFindResponse;
import com.example.user.dto.UserSaveRequest;
import com.example.user.dto.UserSaveResponse;
import com.example.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserFindResponse> find(@PathVariable Long userId) {
        UserFindResponse response = userService.findById(userId);
        if (Objects.isNull(response)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/")
    public ResponseEntity<UserSaveResponse> save(@RequestBody UserSaveRequest userSaveRequest) {
        UserSaveResponse response = userService.save(userSaveRequest);
        return ResponseEntity.ok(response);
    }
}
