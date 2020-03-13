package test.testactive.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test.testactive.domain.Delivery;
import test.testactive.food.Food;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DeliveryRepository {
    private final EntityManager em;


      public void save(Delivery delivery) {
          if (delivery.getId() == null) { // id값이 없기때문에 새로 생성한 객체라고 생
              em.persist(delivery);
          } else {
              em.merge(delivery);   // update??들어온거 합칠꺼임 ㅇ
          }
    }

      public Delivery findOne(Long id) {
        return em.find(Delivery.class, id);
    }

    // 푸드값 반환.
    public List<Delivery> findAll() {
        return em.createQuery("select d from Delivery d", Delivery.class)
                .getResultList();
    }
}
