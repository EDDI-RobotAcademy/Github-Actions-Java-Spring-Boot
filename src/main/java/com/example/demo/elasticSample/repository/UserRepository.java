package com.example.demo.elasticSample.repository;

import com.example.demo.elasticSample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
