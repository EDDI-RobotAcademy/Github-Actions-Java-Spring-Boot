package com.example.demo.member.repository;

import com.example.demo.member.entity.Member;
import com.example.demo.member.entity.MemberProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberProfileRepository extends JpaRepository<MemberProfile, Long> {

    void deleteByMember(Member member);

    Optional<MemberProfile> findByEmail(String email);

    Optional<MemberProfile> findByPhoneNumber(String phoneNumber);

    Optional<MemberProfile> findByMember_MemberId(Long memberId);

}