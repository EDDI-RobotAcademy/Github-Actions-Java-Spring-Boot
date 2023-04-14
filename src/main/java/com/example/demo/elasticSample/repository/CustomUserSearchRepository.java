package com.example.demo.elasticSample.repository;

import com.example.demo.elasticSample.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomUserSearchRepository {

    List<User> searchByName(String name, Pageable pageable);
}
