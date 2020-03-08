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
    public void save(Checklist checklist) {
        em.persist(checklist);
//        if (checklist.getId() == null) { // id값이 없기때문에 새로 생성한 객체라고 생
//            em.persist(checklist);
//        } else {
//            em.merge(checklist);   // update??들어온거 합칠꺼임 ㅇ
//        }
    }
    public Checklist findOne(Long id) {
        return em.find(Checklist.class, id);
    }

}
