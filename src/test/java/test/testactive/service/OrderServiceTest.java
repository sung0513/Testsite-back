package test.testactive.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.repository.OrderRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {


    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;


    @Test
    public void 계산() throws Exception{

           //given



        //when

        //then


        }
}


