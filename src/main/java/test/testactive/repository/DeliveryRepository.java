package test.testactive.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test.testactive.domain.Delivery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor

//status
public class DeliveryRepository {
    @PersistenceContext
    private final EntityManager em;

        Delivery delivery;

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


}
