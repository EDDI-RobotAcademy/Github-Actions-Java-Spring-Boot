package com.example.demo.member.repository;

import com.example.demo.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m join fetch m.authentications where m.userId = :userId")
    Optional<Member> findByUserId(@Param("userId") String userId);

    Optional<Member> findByMemberId(Long memberId);

    void deleteByMemberId(Long memberId);

}
