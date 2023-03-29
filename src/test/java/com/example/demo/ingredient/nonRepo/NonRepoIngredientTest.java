package com.example.demo.ingredient.nonRepo;

import com.example.demo.selfSalad.Controller.form.IngredientRegisterForm;
import com.example.demo.selfSalad.entity.*;
import com.example.demo.selfSalad.repository.*;
import com.example.demo.selfSalad.service.request.IngredientRegisterRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("일반 게시판에 대한 테스트")
@SpringBootTest
public class NonRepoIngredientTest {

//    @Mock
//    private AmountRepository mockAmountRepository;
//    @Mock
//    private IngredientCategoryRepository mockCategoryRepository;
//    @Mock
//    private IngredientRepository mockIngredientRepository;
//    @Mock
//    private IngredientImageRepository mockIngredientImageRepository;
//
//    @InjectMocks
//    private SelfSaladServiceImplBackup mockSelfSaladService;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private IngredientCategoryRepository ingredientCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AmountRepository amountRepository;

    @Autowired
    private IngredientAmountRepository ingredientAmountRepository;

    private MultipartFile imageFile;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    private void prepareFileInputTest () throws IOException {
        final String pathToLoad = Paths.get("D:\\picture\\test.png").toString();
        System.out.println("path: " + pathToLoad);
        File file = new File(pathToLoad);
        FileItem fileItem = new DiskFileItem(
                "mainFile", Files.probeContentType(file.toPath()),
                false, file.getName(), (int) file.length(), file.getParentFile());

        try {
            FileInputStream input = new FileInputStream(file);
            OutputStream output = fileItem.getOutputStream();
            IOUtils.copy(input, output);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        imageFile = new CommonsMultipartFile(fileItem);
    }

    @DisplayName("Post method로 식재료 등록 테스트")
    @Test
    public void 식재료_등록_테스트 () {
//        IngredientRegisterForm ingredientRegisterRequest = new IngredientRegisterForm(
//                "재료이름", "채소", 10000,
//                500, 5, 1, 10,
//                MEASURE1.getMeasure(), new IngredientAmount(), new IngredientImage(null, "test.png", null));
//        /*
//        final private String name;
//        final private CategoryType category;
//        final private Integer price;
//        final private Integer calorie;
//        final private Integer max;
//        final private Integer min;
//        final private Integer unit;
//        final private AmountType measure;
//         */
//
//        Board board = boardRequest.toBoard();
//
//        when(mockBoardRepository.save(board))
//                .thenReturn(new Board("제목", "작성자", "내용"));
//
//        assertThat(mockBoardService.register(boardRequest)).isEqualTo(board);
    }

    @DisplayName("enum Test")
    @Test
    public void enum_변환_테스트 () {
        String receivedData = "MEAT";
        CategoryType categoryType = CategoryType.valueOf(receivedData);

        assertEquals(categoryType, CategoryType.MEAT);
    }

    @DisplayName("enum Test")
    @Test
    public void enum_변환값_입력_테스트 () throws IOException {
        IngredientRegisterForm ingredientRegisterForm =
                new IngredientRegisterForm("돼지고기",
                        CategoryType.MEAT,
                        10000, 50, 5, 1, 1,
                        AmountType.COUNT);

        prepareFileInputTest();
        System.out.println(imageFile.getOriginalFilename());

        IngredientRegisterRequest ingredientRegisterRequest =
                ingredientRegisterForm.toIngredientRegisterRequest(imageFile);

        Ingredient ingredient = ingredientRegisterRequest.toIngredient();
        System.out.println(ingredient);

        ingredientRepository.save(ingredient);

        final Category category =
                categoryRepository.findByCategoryType(ingredientRegisterRequest.getCategoryType()).get();
        final IngredientCategory ingredientCategory =
                new IngredientCategory(ingredient, category);

        ingredientCategoryRepository.save(ingredientCategory);

        System.out.println(category);

        final Amount amount =
                amountRepository.findByAmountType(ingredientRegisterRequest.getAmountType()).get();
        final IngredientAmount ingredientAmount =
                new IngredientAmount(ingredient, amount,
                        ingredientRegisterRequest.getPrice(),
                        ingredientRegisterRequest.getCalorie(),
                        ingredientRegisterRequest.getUnit(),
                        ingredientRegisterRequest.getMax(),
                        ingredientRegisterRequest.getMin());

        ingredientAmountRepository.save(ingredientAmount);
    }
}
