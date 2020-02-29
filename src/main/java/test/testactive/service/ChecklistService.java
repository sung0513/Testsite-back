package test.testactive.service;


//FoodService
//MemberService
//

//장바구니 정보 :
//FoodService: 음식이름, 가격
//Store: 가게이름, 주소, 번호
//Member: 본인의 주소

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
//import org.hibernate.annotations.Check;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.Check;
import test.testactive.domain.Member;
import test.testactive.domain.Order;
import test.testactive.domain.Store;
import test.testactive.food.Food;
import test.testactive.repository.FoodRepository;
import test.testactive.repository.MemberRepository;
import test.testactive.repository.OrderRepository;
import test.testactive.repository.StoreRepository;

import java.util.ArrayList;
import java.util.List;

import static test.testactive.domain.DeliveryStatus.ARRIVE;

//open jdk 1.8v
@Getter
@Setter
@Transactional(readOnly = true)
@AllArgsConstructor
public class ChecklistService<CheckList> {
//    MemberRepository memberRepository;
//    OrderRepository orderRepository;
//    FoodRepository foodRepository;
//    StoreRepository storeRepository;
//
//    @Transactional
//    public List<Member> findMembers() {
//        return memberRepository.findAll();
//    }
//
//    @Transactional
//    public List<Order> findOrder(Long id) {
//        Order order =  orderRepository.findOne(id);
//        return order;
//    }
//
//    @Transactional
//    public List<Store> findStore() {
//        return storeRepository.findAll();
//    }
//
//    @Transactional
//    public List<Food> findFood() {
//        return foodRepository.findAll();
//    }


    private List<Check> check = new ArrayList();


    FoodService foodService;
    MemberService MemberService;
    OrderService orderService;
    StoreService storeService;

}


// 내정보 : 주소랑, 여태까지주문햇던것들, 이름 부가능,

// 현 재 상 황 : 가게정보랑, 음식이름, 주소 db에저장할필요가 없다. 고


