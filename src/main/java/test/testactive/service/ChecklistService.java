package test.testactive.service;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
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

    public Long Check(Long memberId, Long foodId, Long storeId, Long orderId, Long deliveryId) {

        Member member = memberRepository.findOne(memberId);
        Food food = foodRepository.findOne(foodId);
        Store store = storeRepository.findOne(storeId);
        Order order = orderRepository.findOne(orderId);
        Delivery delivery = deliveryRepository.findOne(deliveryId);


        Checklist checklist = Checklist.createchecklist(member, order,food,store,delivery);
        checkRepository.save(checklist);
        return checklist.getId();
    }

}
