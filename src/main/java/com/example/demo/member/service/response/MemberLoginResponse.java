package com.example.demo.member.service.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
public class MemberLoginResponse {

    private Long memberId;
    private String token;

}
