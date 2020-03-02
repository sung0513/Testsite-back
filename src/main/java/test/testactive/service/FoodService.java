package test.testactive.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.food.Food;
import test.testactive.food.Food2Repository;
import test.testactive.repository.FoodRepository;
import test.testactive.request.FoodSaveRequestDto;
import test.testactive.response.FoodListResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FoodService {


    private final Food2Repository food2Repository;// jpa에서 제공하는 인터페이스
    private final FoodRepository foodRepository; //  직접만든 클래스

//    @Transactional //redaOnly 일경우 저장이안됨
//    public Long save(FoodSaveRequestDto fooddto) { //사용자가입력한 정보 저장됨(정확히는 클릭한정보)
//        return food2Repository.save(fooddto.toEntity()).getId(); //인터페이스를 사용하지않을경우 id값이 안땡겨짐
//    }
////
    public void Foodsave(Food food){ //직접만든레포지토리
        foodRepository.save(food);
    }

    @Transactional(readOnly = true)
    public List<FoodListResponseDto> findAllDesc(){
        return foodRepository.findAll().stream().map(FoodListResponseDto::new).collect(Collectors.toList());
        //리스트로 반환하는 메소드이다.
    }

    public List<Food> findFoods() {
        return foodRepository.findAll(); //푸드정보
    }

    public List<FoodListResponseDto> b_findFoods(){return foodRepository.b_findAll().stream().map(FoodListResponseDto::new).collect(Collectors.toList()); }

    @Transactional(readOnly =true)
    public Food findOne(Long foodId) {
        return foodRepository.findOne(foodId);
    }
}

