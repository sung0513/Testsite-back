package test.testactive.service;


//FoodService
//MemberService
//

//장바구니 정보 :
//FoodService: 음식이름, 가격
//Store: 가게이름, 주소, 번호
//Member: 본인의 주소

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.Order;
import test.testactive.domain.Store;
import test.testactive.food.Food;
import test.testactive.repository.FoodRepository;
import test.testactive.repository.OrderRepository;
import test.testactive.repository.StoreRepository;

import java.util.ArrayList;
import java.util.List;

//open jdk 1.8v
@Getter
@Setter
@Transactional(readOnly = true)
@AllArgsConstructor
public class Checklist {
    OrderRepository orderRepository;
    FoodRepository foodRepository;
    StoreRepository storeRepository;
//    private List<Order> order = new ArrayList<>();

    @Transactional
    public Long Checklist(Long orderId, Long foodId, Long storeId) {

        //member food의 각각의 엔티티 조회 id로
        //엔티티조회로 값을 모두가져옴
        Order order = orderRepository.findOne(orderId);
        Food food = foodRepository.findOne(foodId);
        Store store = storeRepository.findOne(storeId);

        storeRepository.save(store);
        orderRepository.save(order);
        foodRepository.save(food);

        return  store.getId(); //스토어정보


        store.getAddress();
        store.getName();
        store.getS_coupon();
        food.getName();
        food.getPrice();
        order.getDelivery(); //딜리버리상태를보여줌

        //        storeRepository.save(store);
//        return  store.getId();
    }
    // 리스트 서비스가 필요가 없다 스토어서비스, 오더서비스, 푸드서비스 에서 전부 가져온다.



    food

}
