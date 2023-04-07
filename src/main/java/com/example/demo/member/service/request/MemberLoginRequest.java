package com.example.demo.member.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class MemberLoginRequest {

    private final String userId;
    private final String password;

}
