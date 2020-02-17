package test.testactive.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import test.testactive.domain.Order;
import test.testactive.domain.Store;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepository {

    @PersistenceContext
    EntityManager em;

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

}