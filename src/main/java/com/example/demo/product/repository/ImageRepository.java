package com.example.demo.product.repository;

import com.example.demo.product.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query("Select i from Image i join fetch i.product p where p.productId = :productId")
    Image findByProductId(Long productId);
}
