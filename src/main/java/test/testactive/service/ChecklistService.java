package test.testactive.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.*;
import test.testactive.food.Food;
import test.testactive.repository.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChecklistService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;
    private final StoreRepository storeRepository;

    private final CheckRepository checkRepository;
    private final DeliveryRepository deliveryRepository;
    /**
     * 주문 / 취소 / 검색 로직을 담겨 있습니다.
     */

    public void checksave(Checklist checklist){ //직접만든레포지토리
        checkRepository.save(checklist);
    }

    @Transactional

    //member, order, food, store,
    public Long Check(Long memberId, Long foodId, Long storeId, Long orderId) {

        //member food의 각각의 엔티티 조회 id로
        Member member = memberRepository.findOne(memberId);
        Food food = foodRepository.findOne(foodId);
        Store store = foodRepository.findOne(storeId);
        Order order = orderRepository.findOne(orderId);


        // delivery에 주소를 세팅
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        //음식 주문로직 -> 음식 , 가격 , 개수가 담겨 있음 -> 문제는 추후 계산 문제
        Orderfood orderfood = Orderfood.createOrderfood(food, food.getPrice(), count);

        //주문에는 주문시킨사람, 배송, 음식배송 정보가 담겨 있음 -> 버전업에서는 다른 여러가지 주문에 대한 사항추가
        Order order = Order.createOrder(member, delivery, orderfood);

        //이것을 orderRepository에서 받아와 주문을 저장한다.
        orderRepository.save(order);
    }
    //주문
//    @Transactional
//    public Long check(Long memberId, Long foodId, Long storeId, Long orderId, Long deliveryId) { //Long 타입이여서 매개변수id를 못받음
//
//        //각각의 엔티티 조회 id로
//
//        Member member = memberRepository.findOne(memberId);
//
//        Food food = foodRepository.findOne(foodId);
//        Order order =orderRepository.findOne(orderId);
//        Store store = storeRepository.findOne(storeId);
////        Delivery delivery = deliveryRepository.findOne(deliveryId);
//
//
//
//
//        //주소, 주문상황, 수량, 가게이름, 음식가격
//        Checklist checklist = Checklist.createchecklist(member, order,food, store);
//
//        //해당값 checklistRepository에서 받아와 주문을 저장한다.
//        checkRepository.save(checklist);
//
//        //그래서 주문의 id를 가져와 반환한다. 각각의 정보를 다 담아서
//        return checklist.getId(); //오더정보
//
//    }

}
