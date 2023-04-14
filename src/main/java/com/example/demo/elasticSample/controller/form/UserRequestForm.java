package com.example.demo.elasticSample.controller.form;

import lombok.ToString;

@ToString
public class UserRequestForm {

    private String name;
    private String description;

    private UserRequestForm() {
    }

    public UserRequestForm(String name, String description) {
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
