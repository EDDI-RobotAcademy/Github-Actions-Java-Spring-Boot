package com.example.demo.elasticSample.controller;

import com.example.demo.elasticSample.controller.form.UserRequestForm;
import com.example.demo.elasticSample.controller.form.UserResponseForm;
import com.example.demo.elasticSample.service.UserService;
import com.example.demo.elasticSample.service.request.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/elastic-sample")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Void> save(@RequestBody UserRequestForm userRequestForm) {
        UserRequest userRequestDto = new UserRequest(
            userRequestForm.getName(),
            userRequestForm.getDescription()
        );

        log.info("requestForm: " + userRequestForm);
        Long id = userService.save(userRequestDto);
        URI uri = URI.create(String.valueOf(id));
        return ResponseEntity.created(uri)
            .build();
    }

    @GetMapping("/users/{name}")
    public ResponseEntity<List<UserResponseForm>> search(@PathVariable String name, Pageable pageable) {
        List<UserResponseForm> userResponses = userService.searchByName(name, pageable)
            .stream()
            .map(UserResponseForm::from)
            .collect(Collectors.toList());
        return ResponseEntity.ok(userResponses);
    }
}
