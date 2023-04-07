package com.example.demo.product.repo;

import com.example.demo.product.controller.form.ProductRegisterForm;
import com.example.demo.product.entity.Image;
import com.example.demo.product.entity.Product;
import com.example.demo.product.entity.ProductInfo;
import com.example.demo.product.repository.ImageRepository;
import com.example.demo.product.repository.ProductInfoRepository;
import com.example.demo.product.repository.ProductRepository;
import com.example.demo.product.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootTest
public class productTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private ProductService productService;

    @Test
    public void 경로_테스트() {
        String path = System.getProperty("user.dir");
        System.out.println("현재 작업 경로: " + path);
    }

    @Test
    public void Paths_기반_경로_테스트() {
        Path currentPath = Paths.get("");
        String path = currentPath.toAbsolutePath().toString();
        System.out.println("현재 작업 경로: " + path);
    }

    @Test
    public void Paths_기반_실제_경로_테스트() {
        Path currentPath = Paths.get("src/test/java/com/example/demo/product/repo/testImage/PERNIT.jpg");
        String path = currentPath.toAbsolutePath().toString();
        System.out.println("Path 기반 현재 실제 작업 경로: " + path);
    }

    @Test
    public void 상품_등록_테스트() throws Exception {
        File[] files = new File[2];

        Path currentPath = Paths.get("src/test/java/com/example/demo/product/repo/testImage/PERNIT.jpg");
        String path = currentPath.toAbsolutePath().toString();
        files[0] = new File(path);

        currentPath = Paths.get("src/test/java/com/example/demo/product/repo/testImage/PERNIT_Detail.jpg");
        path = currentPath.toAbsolutePath().toString();
        files[1] = new File(path);

        List<MultipartFile> multipartFiles = new ArrayList<>();
        System.out.println(files.length);

        try {
            for(File file : files) {
                FileInputStream input = new FileInputStream(file);
                MultipartFile multiPartFile = new MockMultipartFile(file.getName(), input.readAllBytes());
                multipartFiles.add(multiPartFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("here");
        }
        System.out.println("multipartFiles.get(0).toString(): " + multipartFiles.get(0).toString());
        System.out.println("multipartFiles.get(1).toString(): " + multipartFiles.get(1).toString());

        String productName = "좋은약";
        Long productPrice = 10000L;

        ProductRegisterForm productRegisterForm = new ProductRegisterForm(productName, productPrice);
        productService.register(multipartFiles, productRegisterForm.toProductRegisterRequest());

        Optional<Product> mayBeProduct = productRepository.findByProductName(productName);
        Assertions.assertTrue(mayBeProduct.isPresent());

        Product product = mayBeProduct.get();
        System.out.println(product);
        Long product_id = product.getProductId();

        Image mayBeImage = imageRepository.findByProductId(product_id);
        System.out.println(mayBeImage);

        ProductInfo mayBeProductInfo = productInfoRepository.findByProductId(product_id);
        System.out.println(mayBeProductInfo);
    }
}
