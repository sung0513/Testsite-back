package com.example.demo.ServiceTest;

import com.example.demo.domain.*;
import com.example.demo.repository.*;
import com.example.demo.service.FoodService;
import com.example.demo.service.MemberService;
import com.example.demo.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ChecklistServiceTest {
    @Autowired
    private EntityManager em;
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
    ChecklistRepository checkRepository;


    @Autowired
    StoreRepository storeRepository;

    @Autowired
    DeliveryRepository deliveryRepository;


    @Autowired
    ChecklistService checklistService;

    @Autowired
    AddressRepository addressRepository;



    @Test
    public void alltest() {

        String my_name = "현우";
        String Foodname = "분홍피자";
        String store_name = "피자는역시 김밥천국";
        String zipcode = "서울";
        String street = "군자";
        int price = 100000;
        int qu = 10;

        Address address = new Address(zipcode, street);
        Member member = new Member();
        //새로운 방식
        memberRepository.save(Member.builder()
                .name(my_name)
                .address(address)
                .coupon(Coupon.천원)
                .build());
        Long memberId = memberService.SingUp(member);

        Food food = new Food(); //배송량

        foodRepository.save(Food.builder()
                .name(Foodname)
                .price(price)
                .build());
        Food foodId = foodRepository.findOne(food.getId());

        Order order = new Order(); //배송량
        order.User_setQuantity(qu);
        orderRepository.save(order);
        Long orderId = orderService.order(memberId, food.getId(), 3);

        Store store = new Store();

        storeRepository.save(Store.builder()
                .name(store_name)
                .tel("000-111-111")
                .address("경기도 피자왕 분홍피자")
                .build());
        Store storeId = storeRepository.findOne(store.getId());

        Delivery delivery = new Delivery();
        deliveryRepository.save(delivery.builder()
                .address(address)
                .coupon(Coupon.천원)
                .status(DeliveryStatus.ARRIVE)
                .build());

        Checklist checklist = new Checklist();

        Long checkid =  checklistService.Check(member.getId(),food.getId(), order.getId(),store.getId(), delivery.getId());
        assertThat(checklist.getStock()).isEqualTo(qu);
        assertThat(checklist.getStore_name()).isEqualTo(store_name);
        assertThat(checklist.getFood_name()).isEqualTo(Foodname);

    }
}
