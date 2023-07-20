package com.example.user.service;

import com.example.user.dto.UserFindResponse;
import com.example.user.dto.UserSaveRequest;
import com.example.user.dto.UserSaveResponse;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserFindResponse findById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (Objects.isNull(user)) {
            return null;
        }
        return UserFindResponse.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .age(user.getAge())
                .build();
    }

    public UserSaveResponse save(UserSaveRequest request) {
        User user = User.builder()
                .name(request.getName())
                .age(request.getAge())
                .build();
        User saveUser = userRepository.save(user);
        return UserSaveResponse.builder()
                .userId(saveUser.getUserId())
                .name(saveUser.getName())
                .age(saveUser.getAge())
                .build();
    }
}
