package test.testactive.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.*;
import test.testactive.food.Food;
import test.testactive.repository.FoodRepository;
import test.testactive.repository.MemberRepository;
import test.testactive.repository.OrderRepository;
import test.testactive.repository.StoreRepository;
import test.testactive.web.Response.OrderListResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;
    private final StoreRepository storeRepository;


    /**
     * 주문 / 취소 / 검색 로직을 담겨 있습니다.
     */

    /**
     * 저장
     * member_id로 food값 조회가능.
     */

    @Transactional
    public Long order(Long memberId, int count) {

        //member food의 각각의 엔티티 조회 id로
        Member member = memberRepository.findOne(memberId);

        // delivery에 주소를 세팅
        Delivery delivery = new Delivery();
        delivery.DeliverySetAddress_InOrder(member.getAddress()); //주소를 입력받아서 계속 지정하는 형식.

//        //음식 주문로직 -> 음식 , 가격 , 개수가 담겨 있음 -> 문제는 추후 계산 문제
//        Orderfood orderfood = Orderfood.createOrderfood(foods);

        //주문에는 주문시킨사람, 배송, 음식배송 정보가 담겨 있음 -> 버전업에서는 다른 여러가지 주문에 대한 사항추가
        Order order = Order.createOrder(member, delivery);

        //이것을 orderRepository에서 받아와 주문을 저장한다.
        return orderRepository.save(order).getId();

        //그래서 주문의 id를 가져와 반환한다. 각각의 정보를 다 담아서


    }


    /**
     * 취소
     */

    @Transactional
    public void cancelOrder(Long orderId) {

        //주문 내역 조회 -> 내정보에서 확인
        Order order = orderRepository.findOne(orderId); // STATUS
        //주문 취소 로직
        order.cancel();
    }

    //주문정보 전부띄워준다.
    @Transactional(readOnly = true)
    public List<OrderListResponseDto> findAllDesc(){
        return orderRepository.findAll2().stream().map(OrderListResponseDto::new).collect(Collectors.toList());

    }
}

