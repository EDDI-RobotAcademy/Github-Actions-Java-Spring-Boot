package com.example.demo.cart.entity;

import com.example.demo.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(length = 16)
    private Long totalCount;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    private List<CartItem> cartItemList = new ArrayList<>();
}
