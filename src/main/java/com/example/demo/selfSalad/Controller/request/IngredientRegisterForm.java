package com.example.demo.selfSalad.Controller.request;

import com.example.demo.selfSalad.entity.Amount;
import com.example.demo.selfSalad.entity.Category;
import com.example.demo.selfSalad.entity.IngredientImage;
import com.example.demo.selfSalad.entity.convert.StringToIntegerConverter;
import com.example.demo.selfSalad.service.request.IngredientRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Convert;
import java.util.UUID;

@Getter
@ToString
@RequiredArgsConstructor
public class IngredientRegisterForm {

    final private String name;

    final private String categoryName;

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

    public IngredientRegisterRequest toIngredientRegisterRequest (MultipartFile imageFile) {
        UUID randomName = UUID.randomUUID();
        String fileRandomName = randomName + imageFile.getOriginalFilename();

        return new IngredientRegisterRequest(name,
            new Category(categoryName),
            new IngredientImage(fileRandomName),
            new Amount(price, calorie, max, min, unit, measure));
    }
}

