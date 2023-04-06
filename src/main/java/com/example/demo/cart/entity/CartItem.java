package com.example.demo.cart.entity;

import com.example.demo.product.entity.Product;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class CartItem {

    @Id
    @Column(length = 16)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product; // productInfo에서 product로 수정

    @Column(length = 16)
    private Long count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;



}
