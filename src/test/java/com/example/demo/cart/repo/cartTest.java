package com.example.demo.cart.repo;

import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.entity.CartItem;
import com.example.demo.cart.repository.CartItemRepository;
import com.example.demo.cart.repository.CartRepository;
import com.example.demo.cart.service.CartService;
import com.example.demo.cart.service.request.AddCartRequest;
import com.example.demo.cart.service.request.SelectCartItemRequest;
import com.example.demo.cart.service.request.UserInfoRequest;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.product.entity.Product;
import com.example.demo.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


@SpringBootTest
public class cartTest {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartService cartService;

    @Test
    public void 장바구니에_상품_추가_테스트 () {
        // 장바구니에 상품 추가가 어떻게 되는 것인가 ?
        // 흐름 파악이 잘 안됨
        // memberId는 세션, productId는 props
        AddCartRequest addCartRequest =
                new AddCartRequest(1L, 1L, 3L);

        Long memberId = addCartRequest.getMemberId();
        Long productId = addCartRequest.getProductId();
        Long count = addCartRequest.getCount();

        // 카트가 없으면 카트를 생성하고 카트가 있으면 아이템 추가
        Cart cart = createCartIfNoCartElseAddCartItem(memberId);

        Optional<Product> maybeProduct = productRepository.findByProductId(productId);
        Product product = null;

        if(maybeProduct.isPresent()) {
            product = maybeProduct.get();
        }

        System.out.println("product: " + product);

        CartItem cartItem = new CartItem(product, count);
        //cartItem
        System.out.println("cartItem: " + cartItem);

        //cart.setCartItemList(cartItem);
        System.out.println("cartItem: " + cartItem);

        cartRepository.save(cart);

        cartItem.setCart(cart);
        cartItemRepository.save(cartItem);
    }

    private Cart createCartIfNoCartElseAddCartItem(Long memberId) {
        Cart cart = null;
        Optional<Cart> maybeCart = cartRepository.findByMember_MemberId(memberId);
        if(maybeCart.isEmpty()){
            Optional<Member> maybeMember = memberRepository.findByMemberId(memberId);
            Member member = new Member();

            if(maybeMember.isPresent()) {
                member = maybeMember.get();
            }

            System.out.println(member);
            cart = new Cart(3L, member);
            //cartRepository.save(cart);
        }

        // 카트에 아이템 추가할 때
        if(maybeCart.isPresent()) {
            cart = maybeCart.get();
        }

        return cart;
    }

    @Test
    public void 장바구니에서_상품_삭제_테스트 () {
//        SelectCartItemRequest selectCartItemRequest = new SelectCartItemRequest();
//
//        cartService.deleteCartItem(selectCartItemRequest);
//
//        System.out.println("장바구니 아이템 삭제 테스트 완료");
    }

    @Test
    public void 장바구니_아이템_조회_테스트 () {
        //UserInfoRequest userInfoRequest = new UserInfoRequest();
        final Long memberId = 1L;
        //List<CartItem> cartItemList = cartService.findCartItemByMemberId(memberId);
        List<CartItem> cartItemList = cartItemRepository.findCartItemListWithMemberId(memberId);
        System.out.println("cartItemList: " + cartItemList);

        //System.out.println("장바구니 아이템 조회 테스트: "+ cartItemList.toString());
    }
}
