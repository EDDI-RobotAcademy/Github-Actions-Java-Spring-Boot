package com.example.demo.elasticSample.controller.form;

import com.example.demo.elasticSample.service.response.UserResponse;

public class UserResponseForm {

    private Long id;
    private String name;
    private String description;

    private UserResponseForm() {
    }

    public UserResponseForm(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static UserResponseForm from(UserResponse userResponseDto) {
        return new UserResponseForm(
            userResponseDto.getId(),
            userResponseDto.getName(),
            userResponseDto.getDescription()
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
