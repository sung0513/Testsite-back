package test.testactive.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.*;

import test.testactive.repository.DeliveryRepository;

import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
@Rollback(false)
public class DeliveryServiceTest {

    @Autowired
    DeliveryService deliveryService;
    @Autowired
    DeliveryRepository deliveryRepository;


    @Test
    public void testDelivery() throws Exception {

        Delivery delivery = Delivery.builder().build();
        Address address = new Address("강남구", "어딘가");
        Order order = new Order();

        deliveryRepository.save(delivery.builder()
                .status(DeliveryStatus.ARRIVE)
                .address(address)
                .coupon(Coupon.삼천원)
                .order(order)
                .build());

        assertThat(delivery.getStatus()).isEqualTo(DeliveryStatus.ARRIVE);
    }
}