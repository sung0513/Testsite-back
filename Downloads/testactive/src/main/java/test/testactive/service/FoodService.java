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


    @Autowired
    FoodRepository foodRepository;

    @Transactional
    public void saveFood(Food food) {
        foodRepository.save(food);
    }

    public List<Food> findFoods() {
        return FoodRepository.findAll();
    }

    public Food find(Long foodId) {
        return FoodRepository.find(foodId);
    }

}
