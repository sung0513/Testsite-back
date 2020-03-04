package test.testactive.service;

import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.*;
import test.testactive.food.Food;
import test.testactive.food.Food2Repository;
import test.testactive.repository.*;
import test.testactive.request.FoodSaveRequestDto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.print.DocFlavor;
import java.util.List;

import static java.lang.Enum.valueOf;
import static jdk.nashorn.internal.runtime.regexp.joni.constants.Arguments.NON;
import static org.junit.Assert.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;
import static test.testactive.domain.DeliveryStatus.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional


//멤버 : street, id;
//order : stock_quantity
//food : price
//delivery : status
//
public class CheckListTest {


    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    FoodService foodService;

    @Autowired
    CheckRepository checkRepository;


    @Autowired
    StoreRepository storeRepository;

    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    ChecklistService checklistService;


    @Test
    public void alltest() throws Exception {

        String street = "현우";
        String Foodname = "치킨";
        int price = 1000;
        int qu = 3;
        String store_name = "멕시카나";

        Member member = new Member();
        member.setName(street);


        Long memberId = memberService.SingUp(member);
//        ------------------------------------------------------------

        Food food = new Food();
        food.setPrice(price);
        Food foodId = foodService.findOne(food.getId()); //확인해주기

//----------------------------------------------------------------------

        //status는어떡해추가할것인가...
        Order order = new Order(); //배송량
        order.setStockQuantity(qu);
        Order orderId = orderRepository.findOne(order.getId());

        Store store = new Store();
        store.setName(store_name);

        Store storeId= storeRepository.findOne(store.getId());

        Delivery delivery = new Delivery();


        //////////형 해당 이넘클래스 부분오류라서 주석처리했습니당
//        delivery.setStatus(Enum.valueOf(ARRIVE, "도착")); //이넘타입 넘기기.
        Delivery deliveryId = deliveryRepository.findOne(delivery.getId());

        //오류문제
        Checklist checklist = Checklist.createchecklist(member, order, store, food, delivery);

        //해당값 checklistRepository에서 받아와 주문을 저장한다.
        checkRepository.save(checklist);

        assertThat(checklist.getFood()).isEqualTo(price); //푸드테이블확인
        assertThat(checklist.getOrder()).isEqualTo(qu); //가격확인

    }

}
