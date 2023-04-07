package com.example.demo.cart.service.request;

import lombok.Data;

@Data
public class ChangeCartItemCountRequest {

    private Long cartItemId;
    private Long count;
}
