package com.example.demo.cart.service;

import com.example.demo.cart.entity.CartItem;
import com.example.demo.cart.service.request.AddCartRequest;
import com.example.demo.cart.service.request.ChangeCartItemCountRequest;
import com.example.demo.cart.service.request.SelectCartItemRequest;
import com.example.demo.cart.service.request.UserInfoRequest;
import com.example.demo.cart.service.response.CartItemListResponse;

import java.util.List;

public interface CartService {

    public void addCartItem(AddCartRequest addCartRequest);

    public void deleteCartItem(SelectCartItemRequest selectCartItemRequest);

    public List<CartItemListResponse> returnCartItemList(UserInfoRequest userInfoRequest);

    String changeCartItemCount (ChangeCartItemCountRequest changeCartItemCountRequest);
}
