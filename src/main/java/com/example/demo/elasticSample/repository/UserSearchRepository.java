package com.example.demo.elasticSample.repository;

import com.example.demo.elasticSample.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserSearchRepository extends ElasticsearchRepository<User, Long>, CustomUserSearchRepository {

    List<User> findByBasicProfile_NameContains(String name);
}
