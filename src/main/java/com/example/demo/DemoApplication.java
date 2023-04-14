package com.example.demo;

import com.example.demo.elasticSample.repository.CustomUserSearchRepository;
import com.example.demo.elasticSample.repository.UserSearchRepository;
import com.example.demo.posts.repository.PostRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableJpaRepositories(excludeFilters = @ComponentScan.Filter(
		type = FilterType.ASSIGNABLE_TYPE,
		classes = {UserSearchRepository.class, CustomUserSearchRepository.class, PostRepository.class}))
@EnableReactiveMongoRepositories(basePackageClasses = PostRepository.class)
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
