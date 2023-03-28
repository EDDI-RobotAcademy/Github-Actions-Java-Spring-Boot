package com.example.demo.ingredient.nonRepo;

import com.example.demo.selfSalad.entity.Amount;
import com.example.demo.selfSalad.entity.IngredientImage;
import com.example.demo.selfSalad.repository.AmountRepository;
import com.example.demo.selfSalad.repository.CategoryRepository;
import com.example.demo.selfSalad.repository.IngredientImageRepository;
import com.example.demo.selfSalad.repository.IngredientRepository;
import com.example.demo.selfSalad.service.SelfSaladServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.selfSalad.entity.AmountType.MEASURE1;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@DisplayName("일반 게시판에 대한 테스트")
@SpringBootTest
public class NonRepoIngredientTest {

    @Mock
    private AmountRepository mockAmountRepository;
    @Mock
    private CategoryRepository mockCategoryRepository;
    @Mock
    private IngredientRepository mockIngredientRepository;
    @Mock
    private IngredientImageRepository mockIngredientImageRepository;

    @InjectMocks
    private SelfSaladServiceImpl mockSelfSaladService;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @DisplayName("Post method로 식재료 등록 테스트")
    @Test
    public void 식재료_등록_테스트 () {
        IngredientRegisterRequest ingredientRegisterRequest = new IngredientRegisterRequest(
                "재료이름", "채소", 10000,
                500, 5, 1, 10,
                MEASURE1.getMeasure(), new Amount(), new IngredientImage(null, "test.png", null));
        /*
        final private String name;
        final private String category;
        final private Integer price;
        final private Integer calorie;
        final private Integer max;
        final private Integer min;
        final private Integer unit;
        final private AmountType measure;
        final private Amount amount;
        final private IngredientImage image;
         */

        Board board = boardRequest.toBoard();

        when(mockBoardRepository.save(board))
                .thenReturn(new Board("제목", "작성자", "내용"));

        assertThat(mockBoardService.register(boardRequest)).isEqualTo(board);
    }
}
