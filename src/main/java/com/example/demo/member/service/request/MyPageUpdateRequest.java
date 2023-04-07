package com.example.demo.member.service.request;

import com.example.demo.member.entity.Member;
import com.example.demo.member.entity.MemberProfile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class MyPageUpdateRequest {

    private String name;
    private String email;
    private String birthday;
    private String phoneNumber;
    private String newPassword;

    public MemberProfile toMemberProfile(Member member) {
        return new MemberProfile(name, email, birthday, phoneNumber, member);
    }

}
