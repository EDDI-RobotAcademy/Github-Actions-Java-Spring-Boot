package com.example.demo.product.service.request;

import com.example.demo.product.entity.Product;
import com.example.demo.product.entity.ProductInfo;
import lombok.Getter;

@Getter
public class ProductRegisterRequest {
    private final String productName;
    private final Long price;

    public ProductRegisterRequest(String productName, Long price) {
        this.productName = productName;
        this.price = price;
    }

    public Product toProduct() {
        return new Product(productName);
    }

    public ProductInfo toProductInfo() {
        return new ProductInfo(price);
    }
}
