package test.testactive.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.Member;
import test.testactive.domain.Order;
import test.testactive.food.Food;
import test.testactive.food.Food2Repository;
import test.testactive.repository.FoodRepository;
import test.testactive.repository.MemberRepository;
import test.testactive.repository.OrderRepository;
import test.testactive.request.FoodSaveRequestDto;

import java.util.List;

import static org.junit.Assert.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;

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
    Food2Repository food2Repository;



    @Test
    public void alltest() throws Exception {

        Member member = new Member();
        member.setName("현우");

        Long saveId = memberService.SingUp(member);

        assertEquals(member, memberRepository.findOne(saveId)); //member 저장


        //오류수정 foodsaverequestdto

//        FoodSaveRequestDto foodSaveRequestDto = new FoodSaveRequestDto();
        String name = "치킨";

        food2Repository.save(Food.builder()
                .name(name)
                .price(100)
                .build());
//
//        Long foodid = foodService.save(foodSaveRequestDto);

        List<Food> foodList = foodRepository.findAll();

        Food food = foodList.get(0);
        assertThat(food.getName()).isEqualTo(name);
//        assertEquals(foodSaveRequestDto, foodRepository.findOne(foodid)); //member 저장


    }



}
