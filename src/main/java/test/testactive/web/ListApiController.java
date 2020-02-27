package test.testactive.web;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import test.testactive.food.Food;
import test.testactive.repository.FoodRepository;
import test.testactive.request.FoodSaveRequestDto;
import test.testactive.request.StoreSaveRequestDto;
import test.testactive.service.FoodService;
import test.testactive.service.MemberService;
import test.testactive.service.OrderService;
import test.testactive.service.StoreService;

@Service
@RequiredArgsConstructor

public class ListApiController {
    private final FoodService foodService;
    private final MemberService memberService;
    private final OrderService orderService;
    private final StoreService storeService;


    //장바구니에 정보를 보여준다.
    @PostMapping("/api/v1/Foods")
    public Long save(@RequestBody FoodSaveRequestDto foodSaveRequestDto) {
        return foodService.save(foodSaveRequestDto);
    }


//    @PostMapping("/api/v1/Foods")
//    public Long save(@RequestBody StoreSaveRequestDto storeSaveRequestDto) {
//        return storeService.storeInfo(storeSaveRequestDto);
//    }
}



