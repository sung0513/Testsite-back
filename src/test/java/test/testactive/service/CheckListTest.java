package test.testactive.service;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.hibernate.annotations.Check;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
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
import static test.testactive.domain.DeliveryStatus.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
public class CheckListTest {
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

        String street = "현우";
        String Foodname = "치킨";
        int price = 1000;
        int qu = 3;
        String store_name = "멕시카나";

//        Address address = new Address();
//        address.setStreet("광진구");
//        addressService.AddressSave(address);
//        Address addressId = addressService.findOne(address.getId());

        Member member = new Member();
        member.setName(street);
        Long memberId = memberService.SingUp(member);

        Food food = new Food(); //배송량
        food.setName(Foodname);
        food.setPrice(price);
        foodService.Foodsave(food);
        Food foodId = foodService.findOne(food.getId());

        Order order = new Order(); //배송량
        order.setStockQuantity(qu);
        Long orderId = orderService.order(memberId, food.getId(), 3);

        Store store = new Store();
        store.setName(store_name);
        storeService.Storesave(store);
        Store storeId = storeRepository.findOne(store.getId());

        Delivery delivery = new Delivery();
        Address address = new Address("강남구", "어딘가");
        delivery.setStatus(ARRIVE);
        delivery.setAddress(address);


        deliveryService.DeliverySave(delivery);

        Checklist checklist = new Checklist();

        //해당부분오류
        Long checkid =  checklistService.Check(member.getId(), food.getId(), order.getId(),store.getId(), delivery.getId());



        assertThat(checklist.getStock()).isEqualTo(qu);
        assertThat(checklist.getFood_name()).isEqualTo(Foodname);
        assertEquals(checklist, checkRepository.findOne(checkid));
    }
}

