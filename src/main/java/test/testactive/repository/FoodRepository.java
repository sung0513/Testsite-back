package test.testactive.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test.testactive.food.Food;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FoodRepository {

    @PersistenceContext
    private final EntityManager em;

    public void save(Food food) {
        if (food.getId() == null) { // id값이 없기때문에 새로 생성한 객체라고 생
            em.persist(food);
        } else {
            em.merge(food);   // update??들어온거 합칠꺼임 ㅇ
        }
    }


    public Food findOne(Long id) {

        return em.find(Food.class, id);

    }

    // 푸드값 반환.
    public List<Food> findAll() {
        return em.createQuery("select f from Food f", Food.class)
                .getResultList();
    }


    public List<Food> b_findAll() {
        return em.createQuery("select 'FOOD_ID', 'PRICE', 'NAME'  from Food f", Food.class)
                .getResultList();
    }

}