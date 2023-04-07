package com.example.demo.member.service;

import com.example.demo.member.service.request.MemberCheckPasswordRequest;
import com.example.demo.member.service.request.MemberLoginRequest;
import com.example.demo.member.service.request.MemberRegisterRequest;
import com.example.demo.member.service.request.MyPageUpdateRequest;
import com.example.demo.member.service.response.MemberInfoResponse;
import com.example.demo.member.service.response.MemberLoginResponse;

public interface MemberService {

    MemberLoginResponse signIn(MemberLoginRequest toMemberLoginRequest);

    Boolean signUp(MemberRegisterRequest memberRegisterRequest);

    void delete(Long memberId);

    Boolean userIdValidation(String userId);

    Boolean emailValidation(String email);

    Boolean phoneNumberValidation(String phoneNumber);

    Boolean passwordValidation(MemberCheckPasswordRequest memberRequest);

    MemberInfoResponse getMemberInfo(Long memberId);

    Boolean updateMemberInfo(Long memberId, MyPageUpdateRequest myPageUpdateRequest);

}
