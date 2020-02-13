package test.testactive.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test.testactive.food.Food;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FoodRepository {

    private EntityManager em;


    public void save(Food food) {
        if (food.getId() == null) {
            em.persist(food);
        } else {
            em.merge(food);
        }
    }

    public Food find(Long id) {
        return em.find(Food.class, id);
    }
    //
    public List<Food> findAll() {
        return em.createQuery("select f from Food f", Food.class)
                .getResultList();
    }

}