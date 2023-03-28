package com.example.demo.selfSalad.repository;

import com.example.demo.selfSalad.entity.IngredientImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientImageRepository extends JpaRepository<IngredientImage, Long> {
//    Optional<IngredientImage> findByIngredient_Id(Long id);

}
