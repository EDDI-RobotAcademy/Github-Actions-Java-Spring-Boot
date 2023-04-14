package com.example.demo.elasticSample.entity;

import lombok.Data;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

@Document(indexName = "users")
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private BasicProfile basicProfile;

    protected User() {
    }

    public User(String name, String description) {
        this(null, new BasicProfile(name, description));
    }

    @PersistenceCreator
    public User(Long id, BasicProfile basicProfile) {
        this.id = id;
        this.basicProfile = basicProfile;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return basicProfile.getName();
    }

    public String getDescription() {
        return basicProfile.getDescription();
    }
}
