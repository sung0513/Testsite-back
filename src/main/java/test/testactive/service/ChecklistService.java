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

    /**
     * 주문 / 취소 / 검색 로직을 담겨 있습니다.
     */

    //주문
    @Transactional
    public Long check(Long memberId, Long foodId, Long storeId, Long orderId) { //Long 타입이여서 매개변수id를 못받음

        //각각의 엔티티 조회 id로

        Member member = memberRepository.findOne(memberId);
        Food food = foodRepository.findOne(foodId);
        Order order =orderRepository.findOne(orderId);
        Store store = storeRepository.findOne(storeId);



        //주소, 주문상황, 수량, 가게이름, 음식가격
        Checklist checklist = Checklist.createchecklist(member, order, store, food);

        //해당값 checklistRepository에서 받아와 주문을 저장한다.
        checkRepository.save(checklist);

        //그래서 주문의 id를 가져와 반환한다. 각각의 정보를 다 담아서
        return checklist.getId(); //오더정보

    }

}
