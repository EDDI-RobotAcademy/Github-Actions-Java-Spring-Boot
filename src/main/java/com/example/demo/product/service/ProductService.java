package com.example.demo.product.service;

import com.example.demo.product.controller.form.ProductListResponse;
import com.example.demo.product.service.request.ProductRegisterRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    public void register(List<MultipartFile> imageFileList, ProductRegisterRequest productRegisterRequest);
    public List<ProductListResponse> getDefaultList();
}
