package test.testactive.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test.testactive.domain.*;
import test.testactive.food.Food;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class CheckRepository {


    EntityManager em;

    public void save(Checklist checklist) {
            em.persist(checklist);
        }



    public Checklist findOne(Long id) {
        return em.find(Checklist.class, id);
    }

}
