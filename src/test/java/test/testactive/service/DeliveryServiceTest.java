package test.testactive.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.Address;
import test.testactive.domain.Delivery;
import test.testactive.repository.DeliveryRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static test.testactive.domain.DeliveryStatus.ARRIVE;


@SpringBootTest
@Transactional
@Rollback(false)
@RunWith(SpringRunner.class)

public class DeliveryServiceTest {

    @Autowired
    DeliveryService deliveryService;
    @Autowired
    DeliveryRepository deliveryRepository;



    @Test
    public void testDelivery() throws Exception {

        Delivery delivery = new Delivery();
        Address address = new Address("강남구","어딘가");

        delivery.setStatus(ARRIVE);
        delivery.setAddress(address);

        deliveryRepository.save(delivery);
//        Long dId = deliveryService.SingUp(delivery);

        assertThat(delivery.getStatus()).isEqualTo(ARRIVE);
//        assertEquals(delivery, deliveryRepository.findOne(dId));
    }
}