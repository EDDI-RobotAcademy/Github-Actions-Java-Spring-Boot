package com.example.demo.member.repository;

import com.example.demo.member.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {

    Optional<Authentication> findByMember_MemberId(Long memberId);

}
