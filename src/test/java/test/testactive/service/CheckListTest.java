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
import test.testactive.food.Food2Repository;
import test.testactive.repository.*;
import test.testactive.request.FoodSaveRequestDto;

import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.print.DocFlavor;
import java.util.List;

import static java.lang.Enum.valueOf;
import static jdk.nashorn.internal.runtime.regexp.joni.constants.Arguments.NON;
import static org.junit.Assert.assertEquals;

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

        String my_name = "현우짱";
        String Foodname = "hot";
        int price = 100000;
        int qu = 10;
        String store_name = "네네치킨";

        Address address = new Address("강남구", "키키동");
        Member member = new Member();
        //새로운 방식
       Long memberId = memberService.SingUp(Member.builder()
                .name(my_name)
                .address(address)
                .coupon(천원)
                .build());


        Food food = new Food(); //배송량
        food.setName(Foodname);
        food.setPrice(price);
        foodService.Foodsave(food);
        Food foodId = foodService.findOne(food.getId());


//        Order order = Order.builder().build();
//        orderRepository.save(Order.builder()
//                .stockQuantity(qu)
//                .build());
        Order order = new Order(); //배송량
        order.setStockQuantity(qu);
        orderRepository.save(order);
        Long orderId = orderService.order(memberId, food.getId(), 3);

        Store store = new Store();
        store.setName(store_name);
        storeService.Storesave(store);
        Store storeId = storeRepository.findOne(store.getId());

        //builder로는 저장이안됨 ㄷㄷ...
        Delivery delivery = Delivery.builder().build();
        deliveryService.DeliverySave(Delivery.builder()
                .status(READY)
                .address(address)
                .build());


        Checklist checklist = new Checklist();

        Long checkid =  checklistService.Check(food.getId(), orderId,store.getId(), delivery.getId(), address);
        assertThat(checklist.getStock()).isEqualTo(qu);
        assertThat(checklist.getStore_name()).isEqualTo(store_name);
        assertThat(checklist.getFood_name()).isEqualTo(Foodname);

    }
}

