package com.example.demo.member.service.request;

import com.example.demo.member.entity.Member;
import com.example.demo.member.entity.MemberProfile;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class MemberRegisterRequest {

    final private String name;
    final private String userId;
    final private String password;
    final private String email;
    final private String birthday;
    final private String phoneNumber;

    public Member toMember () {
        return new Member(userId);
    }

    public MemberProfile toMemberProfile(Member member) {
        return new MemberProfile(name, email, birthday, phoneNumber, member);
    }

}
