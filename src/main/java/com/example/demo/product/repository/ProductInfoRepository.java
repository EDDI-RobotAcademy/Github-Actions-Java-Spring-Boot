package com.example.demo.product.repository;

import com.example.demo.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {
    @Query("Select i from ProductInfo i join fetch i.product p where p.productId = :productId")
    ProductInfo findByProductId(Long productId);
}
