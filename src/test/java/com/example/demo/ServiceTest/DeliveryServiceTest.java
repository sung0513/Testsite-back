package com.example.demo.ServiceTest;


import com.example.demo.domain.*;
import com.example.demo.repository.DeliveryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.demo.domain.Coupon.천원;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DeliveryServiceTest {

    @Autowired
    DeliveryRepository deliveryRepository;


    @Test
    public void Insert_Test(){

        String street = "서울시";
        String zipcode ="강남구";
        Address address = new Address(zipcode,street);

        deliveryRepository.save(Delivery.builder()
                .address(address)
                .coupon(Coupon.천원)
                .status(DeliveryStatus.ARRIVE)
                .build());
        List<Delivery> mm = deliveryRepository.findAll();

        Delivery delivery = mm.get(0);
        System.out.println(delivery.getCreatedDate());
        assertThat(delivery.getAddress()).isEqualTo(address);
        assertThat(delivery.getCoupon()).isEqualTo(천원);
        assertThat(delivery.getStatus()).isEqualTo(DeliveryStatus.ARRIVE);
    }
}
