package test.testactive.service;


import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.food.Food;
import test.testactive.food.Food2Repository;
import test.testactive.repository.FoodRepository;
import test.testactive.request.FoodSaveRequestDto;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FoodService {


    private final Food2Repository food2Repository;
    private final FoodRepository foodRepository;

    @Transactional //redaOnly 일경우 저장이안됨요
    public Long save(FoodSaveRequestDto foodSaveRequestDto) {
        return food2Repository.save(foodSaveRequestDto.toEntity()).getId();
    }
    public List<Food> findFoods() {
        return foodRepository.findAll();
    }

    public Food findOne(Long foodId) {
        return foodRepository.findOne(foodId);
    }



}

