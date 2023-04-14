package com.example.demo.elasticSample.service;

import com.example.demo.elasticSample.entity.User;
import com.example.demo.elasticSample.repository.UserRepository;
import com.example.demo.elasticSample.repository.UserSearchRepository;
import com.example.demo.elasticSample.service.request.UserRequest;
import com.example.demo.elasticSample.service.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserSearchRepository userSearchRepository;

    @Transactional
    public Long save(UserRequest userRequestDto) {
        User user = new User(userRequestDto.getName(), userRequestDto.getDescription());
        User savedUser = userRepository.save(user);
        userSearchRepository.save(user);
        return savedUser.getId();
    }

    public List<UserResponse> searchByName(String name, Pageable pageable) {
        // userSearchRepository.findByBasicProfile_NameContains(name) 가능
        return userSearchRepository.searchByName(name, pageable)
            .stream()
            .map(UserResponse::from)
            .collect(Collectors.toList());
    }
}
