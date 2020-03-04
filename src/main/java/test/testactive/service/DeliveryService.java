package test.testactive.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.Address;
import test.testactive.domain.Delivery;
import test.testactive.domain.Store;
import test.testactive.repository.DeliveryRepository;
import test.testactive.repository.StoreRepository;
import test.testactive.response.StoreListResponseDto;

import java.util.List;
import java.util.stream.Collectors;



@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DeliveryService {


    private final DeliveryRepository deliveryRepository;

    public void DeliverySave(Delivery delivery){ //직접만든레포지토리
            deliveryRepository.save(delivery);
        }

    }