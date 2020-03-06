package test.testactive.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.Address;
import test.testactive.domain.Delivery;
import test.testactive.domain.Store;
import test.testactive.food.Food;
import test.testactive.repository.DeliveryRepository;
import test.testactive.repository.MemberRepository;
import test.testactive.repository.StoreRepository;
import test.testactive.response.StoreListResponseDto;

import java.util.List;
import java.util.stream.Collectors;



@Service
@Transactional(readOnly = true)

public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }
    @Transactional
    public void DeliverySave(Delivery delivery){ //직접만든레포지토리
            deliveryRepository.save(delivery);
        }


    @Transactional
    public Long SingUp(Delivery delivery) {

       ///
        deliveryRepository.save(delivery);
        ///
        return delivery.getId();
    }

    }