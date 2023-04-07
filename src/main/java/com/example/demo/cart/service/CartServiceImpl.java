package com.example.demo.cart.service;

import com.example.demo.cart.entity.Cart;
import com.example.demo.cart.entity.CartItem;
import com.example.demo.cart.repository.CartItemRepository;
import com.example.demo.cart.repository.CartRepository;
import com.example.demo.cart.service.request.AddCartRequest;
import com.example.demo.cart.service.request.ChangeCartItemCountRequest;
import com.example.demo.cart.service.request.SelectCartItemRequest;
import com.example.demo.cart.service.request.UserInfoRequest;
import com.example.demo.cart.service.response.CartItemListResponse;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.product.entity.Product;
import com.example.demo.product.repository.ProductRepository;
import com.example.demo.security.service.RedisService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Getter
@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    @Autowired
    private final CartRepository cartRepository;

    @Autowired
    private final CartItemRepository cartItemRepository;

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private final ProductRepository productRepository;

//    @Autowired
//    private RedisService redisService;


    @Override
    @Transactional
    public void addCartItem(AddCartRequest addCartRequest) {

        Long memberId = addCartRequest.getMemberId();
        Long productId = addCartRequest.getProductId();
        Long count = addCartRequest.getCount();

        Optional<Cart> maybeCart = cartRepository.findByMember_MemberId(memberId);


        // 카트가 생성되어 있지 않다면
        if(maybeCart.isEmpty()){
            Optional<Member> maybeMember = memberRepository.findByMemberId(memberId);
            Member member = new Member();

            if(maybeMember.isPresent()) {
                member = maybeMember.get();
            } else {
                // pass
            }
            System.out.println(member);
            Cart cart = new Cart(0L, member);

            cartRepository.save(cart);
        }

        // 카트에 아이템 추가할 때
        maybeCart = cartRepository.findByMember_MemberId(memberId);
        Cart cart = null;

        if(maybeCart.isPresent()) {
            cart = maybeCart.get();
        } else {
            // pass
        }

        Optional<Product> maybeProduct = productRepository.findByProductId(productId);
        Product product = null;

        if(maybeProduct.isPresent()) {
            product = maybeProduct.get();
        } else {
            // pass
        }

        CartItem cartItem = new CartItem(product, count);

        //cart.setTotalCount(cart.getTotalCount() + 1);
        //cartRepository.save(cart);
        cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItem(SelectCartItemRequest selectCartItemRequest){
//        List<Long> deleteCartItemId = selectCartItemRequest.getSelectCartItemId();
//        //Cart cart = new Cart();
//
//        for (int i = 0; i < deleteCartItemId.size() ; i++) {
//            cartItemRepository.deleteById(deleteCartItemId.get(i));
//            //cart.setTotalCount(cart.getTotalCount() - 1);
//        }

    }

    @Transactional
    @Override
    public List<CartItemListResponse> returnCartItemList(UserInfoRequest userInfoRequest){
//        Long memberId = userInfoRequest.getMemberId();
//
//        // 리포지터리에서 멤버아이디를 기준으로 찾아온 카트리스트 정보를 저장할 새로운 리스트 생성
//        Cart cart = cartRepository.findCartByMemberId(memberId);
//        //List<CartItem> cartItemList = cartItemRepository.findCartListByCartId(cart.getCartId());
//
//        log.info("can I pass findCartLIstByMemberId() ?");
//        //log.info("cartItemList: " + cartItemList);
//
//        // 리턴을 위해 리스폰스 리스트 생성
//        List<CartItemListResponse> cartItemListResponseList = new ArrayList<>();

        // 정보를 저장하기 위해 돌리는 foreach문...
//        for(CartItem cartItem: cartItemList) {
//            CartItemListResponse cartItemListResponse = new CartItemListResponse(cartItem);

//            log.info("cartItemListResponse: " + cartItemListResponse);
//
//            Optional<Member> maybeMember = memberRepository.findByMemberId(memberId);
//            cartItemListResponse.getCart().setMember(maybeMember.get());
//
//            log.info("maybeMember.get(): " + maybeMember.get());
//            log.info("cartItemListResponse.getProduct(): " + cartItemListResponse.getProduct());
//            log.info("cartItemListResponse.getCart(): " + cartItemListResponse.getCart());

//            cartItemListResponseList.add(cartItemListResponse);
//        }
//
        return null;
    }

    @Override
    public String changeCartItemCount(ChangeCartItemCountRequest changeCartItemCountRequest) {
//        CartItem cartItem = cartItemRepository.findCartItemByCartItemId(changeCartItemCountRequest.getCartItemId());
//
//        //cartItem.setCount(changeCartItemCountRequest.getCount());
//
//        cartItemRepository.save(cartItem);
        return "1";
    }

}
