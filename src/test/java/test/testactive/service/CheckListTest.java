package test.testactive.service;

import jdk.nashorn.internal.objects.annotations.Getter;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.hibernate.annotations.Check;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.*;
import test.testactive.food.Food;
import test.testactive.repository.*;

import static org.assertj.core.api.Assertions.assertThat;
import static test.testactive.domain.Coupon.천원;
import static test.testactive.domain.DeliveryStatus.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
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
    DeliveryService deliveryService;

    @Autowired
    ChecklistService checklistService;


    @Autowired
    StoreService storeService;



    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AddressService addressService;



    @Test
    public void alltest() {

        String my_name = "현우가";
        String Foodname = "매운족발";
        int price = 100000;
        int qu = 12;
        String store_name = "가족";

        Address address = new Address("강남구", "키키동");
        Member member = new Member();
        //새로운 방식
       Long memberId = memberService.SingUp(Member.builder()
                .name(my_name)
                .address(address)
                .coupon(천원)
                .build());


        Food food = Food.builder().build();
        Long foodId = foodService.SingUp(food.builder()
                .name(Foodname)
                .price(price)
                .build());



        Long orderId = orderService.order(memberId, foodId, 3,qu);


        Store store = Store.builder().build();

        Long storeId = storeService.Storesave(store.builder()
                        .name(store_name)
                        .build());


        Delivery delivery = Delivery.builder().build();

        Long deliveryId = deliveryService.DeliverySave(Delivery.builder()
                .status(READY)
                .address(address)
                .build());


        Checklist checklist = new Checklist();

        Long checkid =  checklistService.Check(foodId, orderId,storeId, deliveryId, address);
        assertThat(checklist.getStock()).isEqualTo(qu);
        assertThat(checklist.getStore_name()).isEqualTo(store_name);
        assertThat(checklist.getFood_name()).isEqualTo(Foodname);

    }
}

