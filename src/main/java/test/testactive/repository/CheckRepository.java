package test.testactive.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test.testactive.domain.*;
import test.testactive.food.Food;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class CheckRepository {

    @PersistenceContext
    private final EntityManager em;

    Checklist checklist;

    public Checklist findOne(Long id) {
        return em.find(Checklist.class, id);
    }
    public void save(Checklist checklist) {
        em.persist(checklist);
    }


    public void CheckOrder(Checklist checklist) {
        if (checklist.getStatus() == DeliveryStatus.SUCCESS) {
            em.remove(checklist);
        }
    }

}
