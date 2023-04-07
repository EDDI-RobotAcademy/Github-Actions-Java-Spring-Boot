package com.example.demo.product.repository;

import com.example.demo.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository  extends JpaRepository<Product, Long> {
    @Query("Select p from Product p where p.productName = :productName")
    Optional<Product> findByProductName(String productName);

    Optional<Product> findByProductId(Long productId);
}
