package test.testactive.web;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import test.testactive.food.Food;
import test.testactive.repository.FoodRepository;
import test.testactive.request.FoodSaveRequestDto;
import test.testactive.service.FoodService;

@Service
@RequiredArgsConstructor

public class FoodApiController {

    private final FoodService foodService;

    @PostMapping("/api/v1/Foods")
    public Long save(@RequestBody FoodSaveRequestDto foodSaveRequestDto) {
        return foodService.save(foodSaveRequestDto); //
    }
}

//
//}
