package com.example.demo.elasticSample.service.request;

public class UserRequest {

    private String name;
    private String description;

    private UserRequest() {
    }

    public UserRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
