package com.example.demo.selfSalad.service.request;

import com.example.demo.selfSalad.entity.Amount;
import com.example.demo.selfSalad.entity.Category;
import com.example.demo.selfSalad.entity.Ingredient;
import com.example.demo.selfSalad.entity.IngredientImage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class IngredientRegisterRequest {

    final private String name;
    final private Category category;
    final private IngredientImage ingredientImage;
    final private Amount amount;

    public Ingredient toIngredient () {
        return new Ingredient(name, category, ingredientImage, amount);
    }
}
