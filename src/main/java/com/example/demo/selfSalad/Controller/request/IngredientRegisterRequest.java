package com.example.demo.selfSalad.Controller.request;

import com.example.demo.selfSalad.entity.Amount;
import com.example.demo.selfSalad.entity.IngredientImage;
import com.example.demo.selfSalad.entity.convert.StringToIntegerConverter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Convert;

@Getter
@RequiredArgsConstructor
public class IngredientRegisterRequest {

    final private String name;

    final private String category;

    @Convert(converter = StringToIntegerConverter.class, attributeName = "price_convert")
    final private Integer price;

    @Convert(converter = StringToIntegerConverter.class, attributeName = "calorie_convert")
    final private Integer calorie;

    // amount
    @Convert(converter = StringToIntegerConverter.class, attributeName = "amount_convert")
    final private Integer max;

    @Convert(converter = StringToIntegerConverter.class, attributeName = "amount_convert")
    final private Integer min;

    @Convert(converter = StringToIntegerConverter.class, attributeName = "amount_convert")
    final private Integer unit;

    final private String measure;

    final private Amount amount;

    final private IngredientImage image;

//    public Amount toEntity(){
//        return new Amount(max, min, unit, price, calorie, measure);
//    }

//    public Ingredient registerName( ){
//        return new Ingredient(name, amount, image);
//    }



}

