package test.testactive.service;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.*;
import test.testactive.food.Food;
import test.testactive.repository.*;

@Service
@RequiredArgsConstructor
public class ChecklistService {

    private final OrderRepository orderRepository;
    private final FoodRepository foodRepository;
    private final StoreRepository storeRepository;
    private final CheckRepository checkRepository;
    private final DeliveryRepository deliveryRepository;

    /**
     * 주문 / 취소 / 검색 로직을 담겨 있습니다.
     */

    @Transactional
    public void checksave(Checklist checklist) { //직접만든레포지토리
        checkRepository.save(checklist);
    }

    @Transactional
    public Long Check(Long foodId, Long storeId, Long orderId, Long deliveryId, Address address) {
        Food food = foodRepository.findOne(foodId);
        Store store = storeRepository.findOne(storeId);
        Order order = orderRepository.findOne(orderId);
        Delivery delivery = deliveryRepository.findOne(deliveryId);


        Checklist checklist = Checklist.createchecklist(order, food, store, delivery, address);
        checkRepository.save(checklist);
        return checklist.getId();
    }

}
