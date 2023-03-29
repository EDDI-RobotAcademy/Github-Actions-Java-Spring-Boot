package com.example.demo.selfSalad.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SelfSaladServiceImplBackup {
//
//    @Autowired
//    IngredientRepository ingredientRepository;
//
//    @Autowired
//    IngredientCategoryRepository categoryRepository;
//
//    @Autowired
//    IngredientImageRepository ingredientImageRepository;
//
//    @Autowired
//    AmountRepository amountRepository;
//
//    public void createCategory(Long id, CategoryType categoryType){
//        IngredientCategory category = new IngredientCategory(id, categoryType);
//        categoryRepository.save(category);
//    }
//
//    @Override
//    @Transactional
//    public boolean register(IngredientRegisterRequest request){
//
//        // 1. 카테고리 찾기
//        log.info("requestIngredientType : " + request.getIngredientCategory());
//
//        Optional<IngredientCategory> maybeCategory =
//                //categoryRepository.findByCategoryName(request.getIngredientCategory().getCategoryType());
//                categoryRepository.findByCategoryName("request.getIngredientCategory().getCategoryType()");
//
//        log.info("1 차 시도");
//
//        if (maybeCategory.isEmpty()) {
//            return false;
//        }
//        IngredientCategory category = maybeCategory.get();
//
//        log.info("카테고리 찾았다");
//
//        // 2. 재료 entity 생성 : 하위에 계속 추가해 최종적으로 리포지터리에 저장
//        Ingredient ingredient = new Ingredient();
//        ingredient.registerName( request.getName());
//
////        // 2. 수량 entity
////        log.info(request.getUnit().toString());
////        IngredientAmount amount = new IngredientAmount(request.getMax(), request.getMin(), request.getUnit(), request.getPrice(), request.getCalorie(),
////                request.getMeasure(), ingredient);
////        //IngredientAmount amount = request.toEntity();
////
////            // 수량 entity 에 재료 넣기
////        ingredient.registerAmount(amount);
////        log.info(amount.getUnit().toString());
////
////        amountRepository.save(amount);
////
////        log.info("request.toIngredient(amount): IngredientAmount 추가");
////
////
////        // 4. 이미지
////        final String fixedStringPath = "../../SSS-Front/frontend/src/assets/selfSaladImgs/";
////        try {
////            log.info("requestImageFile - filename: " + image.getOriginalFilename());
////
////            UUID randomName = UUID.randomUUID();
////            String fileRandomName = randomName + image.getOriginalFilename();
////
////            // 파일 경로지정
////            FileOutputStream writer = new FileOutputStream(
////                    fixedStringPath + fileRandomName);
////
////            writer.write(image.getBytes());
////            writer.close();
////
////            IngredientImage ingredientImage = new IngredientImage(
////                    image.getOriginalFilename(),
////                    fileRandomName,
////                    ingredient
////            );
////
////            // Ingredient.class에 재료 이미지 entity 저장
////            ingredientImage.registerToIngredient();
////            ingredientImageRepository.save(ingredientImage);
////
////
////        } catch (FileNotFoundException e) {
////            throw new RuntimeException(e);
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
////
////        // 해당 카테고리에 새로운 재료 entity 를 저장
////        ingredient.registerToCategory( category);
////        log.info("여기였군");
////
////        ingredientRepository.save( ingredient);
//
//        return true;
//    }
//
//    @Override
//    public void createCategory(Long id, String name) {
//
//    }
//
//    @Override
//    public List<Ingredient> list(String requestType){
//
//        Optional<IngredientCategory> maybeCategory = categoryRepository.findByCategoryName(requestType);
//
//        if (maybeCategory.isEmpty()) {
//            return null;
//        }
//        IngredientCategory category = maybeCategory.get();
//
//        //List <Ingredient>maybeIngredient = ingredientImageRepository.findByCategoryId( category.getId());
//
//        //return ingredientRepository.findByCategoryId( category.getId());
//        return null;
//
//    }

}
