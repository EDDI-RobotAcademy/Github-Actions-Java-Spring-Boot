package com.example.demo.selfSalad.service.request;

import com.example.demo.selfSalad.entity.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class IngredientRegisterRequest {

    final private String name;
    final private CategoryType categoryType;
    final private Integer price;
    final private Integer calorie;
    final private Integer max;
    final private Integer min;
    final private Integer unit;
    final private AmountType amountType;
    final private String fileRandomName;

    public Ingredient toIngredient () {
        return new Ingredient(
                name,
                IngredientImage.of(fileRandomName));
    }

    public IngredientCategory toIngredientCategory (Ingredient ingredient) {
        return new IngredientCategory(ingredient, new Category(categoryType));
    }

    public IngredientAmount toIngredientAmount (Ingredient ingredient) {
        return new IngredientAmount(
                ingredient,
                new Amount(amountType),
                price, calorie, unit, max, min);
    }
}
