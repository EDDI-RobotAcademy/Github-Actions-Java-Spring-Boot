package com.example.demo.cart.service.response;

import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.entity.CartItem;
import com.example.demo.product.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class CartItemListResponse {


    private Long cartItemId;

    private Product product;

    private Long count;
    // 상품 개수 (ex. A상품 2개)

    private Cart cart;

    public CartItemListResponse(CartItem cartItem) {
//        this.cartItemId = cartItem.getCartItemId();
//        this.product = cartItem.getProduct();
//        this.count = cartItem.getCount();
//        this.cart = cartItem.getCart();
    }

}
