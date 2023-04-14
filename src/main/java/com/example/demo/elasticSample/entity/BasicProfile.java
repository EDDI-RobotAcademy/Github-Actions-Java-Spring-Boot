package com.example.demo.elasticSample.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BasicProfile {

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    protected BasicProfile() {
    }

    public BasicProfile(String name, String description) {
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
