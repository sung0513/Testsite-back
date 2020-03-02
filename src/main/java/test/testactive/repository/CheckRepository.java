package test.testactive.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test.testactive.domain.Checklist;
import test.testactive.food.Food;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@RequiredArgsConstructor

public class CheckRepository {

    private EntityManager em;
    private Checklist checklist;

    public void save(Checklist check) {
        if (check.getId() == null) { // id값이 없기때문에 새로 생성한 객체라고 생
            em.persist(check);
        } else {
            em.merge(check);   // update??들어온거 합칠꺼임 ㅇ
        }
    }
    public List<Checklist> findAll() {
        return em.createQuery("select c from Checklist c", Checklist.class)
                .getResultList();
    }
}
