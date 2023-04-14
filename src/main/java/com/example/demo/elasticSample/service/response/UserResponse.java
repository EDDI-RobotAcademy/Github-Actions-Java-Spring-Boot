package com.example.demo.elasticSample.service.response;

import com.example.demo.elasticSample.entity.User;

public class UserResponse {

    private Long id;
    private String name;
    private String description;

    private UserResponse() {
    }

    public UserResponse(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static UserResponse from(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getDescription());
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
