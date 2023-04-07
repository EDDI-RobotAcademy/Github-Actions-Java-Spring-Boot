package com.example.demo.cart.service.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserInfoRequest {

    private Long memberId;
    private String token;

}