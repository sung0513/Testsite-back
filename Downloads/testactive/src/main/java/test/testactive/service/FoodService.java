package test.testactive.service;


import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.food.Food;
import test.testactive.repository.FoodRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FoodService {


    private final FoodRepository foodRepository;

    @Transactional //redaOnly 일경우 저장이안됨요
    public void saveFood(Food food) {
        foodRepository.save(food);
    }
    public List<Food> findFoods() {
        return foodRepository.findAll();
    }

    public Food findOne(Long foodId) {
        return foodRepository.findOne(foodId);
    }



}

