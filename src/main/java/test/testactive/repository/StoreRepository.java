package test.testactive.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import test.testactive.domain.Order;
import test.testactive.domain.Store;
import test.testactive.food.Food;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

//디비에 저장된 정보를 웹에띠워준다.
//웹에정보를클릭하면 우리가확인할수있는 클래스도필요함.


@Repository
@RequiredArgsConstructor
public class StoreRepository {

    @PersistenceContext
    private final EntityManager em;


    @Transactional
    public Store save(Store store) {
        em.persist(store);
        return store;
    }

    public Store findOne(Long id) {
        return em.find(Store.class, id);
    }

    public List<Store> findStore(Store store) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Store> cq = cb.createQuery(Store.class);
        Root<Store> s = cq.from(Store.class);
        List<Predicate> criteria = new ArrayList<Predicate>();

        if (StringUtils.hasText(store.getName())) {
            Predicate info =
                    cb.equal(s.get("storeInfo"), Store.class);
            criteria.add(info);

        }

        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Store> query =
                em.createQuery(cq).setMaxResults(100);
        return query.getResultList();
    }


    public List<Store> b_findAll() {
        return em.createQuery("select 'STORE_NAME','STORE_TEL'  from Store ", Store.class)
                .getResultList();
    }

}
