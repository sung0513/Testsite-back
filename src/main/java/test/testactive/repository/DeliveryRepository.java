package test.testactive.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test.testactive.domain.Delivery;
import test.testactive.domain.Order;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor

//status
public class DeliveryRepository {
        EntityManager em;


      public void save(Delivery delivery) {
        em.persist(delivery);
    }

      public Delivery findOne(Long id) {
        return em.find(Delivery.class, id);
    }


}
