package test.testactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.Delivery;
import test.testactive.domain.DeliveryStatus;
import test.testactive.repository.DeliveryRepository;


@Service
@Transactional(readOnly = true)

public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }
    @Transactional
    public Long DeliverySave(Delivery delivery){ //직접만든레포지토리
            deliveryRepository.save(delivery);
            return delivery.getId();
        }

    @Transactional
    public Long SingUp(Delivery delivery) {

       ///
        deliveryRepository.save(delivery);

        return delivery.getId();
    }

    @Transactional(readOnly =true)
    public Delivery findOne(Long deliveryId) {
        return deliveryRepository.findOne(deliveryId);
    }


    @Transactional(readOnly =true)
    public DeliveryStatus findStatus(Long deliveryId) {
        Delivery delivery = deliveryRepository.findOne(deliveryId);
        return delivery.getStatus();
    }

}