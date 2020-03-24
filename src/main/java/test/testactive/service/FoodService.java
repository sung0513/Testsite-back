package test.testactive.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.Member;
import test.testactive.food.Food;
import test.testactive.food.Food2Repository;
import test.testactive.repository.FoodRepository;

import test.testactive.web.Response.FoodListResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository; //  직접만든 클래스

    public void Foodsave(Food food) { //직접만든레포지토리
        foodRepository.save(food);
    }

    @Transactional(readOnly = true)
    public List<FoodListResponseDto> findAllDesc() {
        return foodRepository.findAll().stream().map(FoodListResponseDto::new).collect(Collectors.toList());
        //리스트로 반환하는 메소드이다.
    }

    public List<Food> findFoods() {
        return foodRepository.findAll(); //푸드정보
    }

    public List<FoodListResponseDto> b_findFoods() {
        return foodRepository.b_findAll().stream().map(FoodListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Food findOne(Long foodId) {
        return foodRepository.findOne(foodId);
    }

    @Transactional
    public Long SingUp(Food food) {
        foodRepository.save(food);
        return food.getId();
    }
}

