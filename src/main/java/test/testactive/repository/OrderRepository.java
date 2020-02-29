package test.testactive.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import test.testactive.domain.Member;
import test.testactive.domain.Order;
import test.testactive.domain.OrderSearch;
import test.testactive.food.Food;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {


    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }


    public List<Order> findAll(OrderSearch orderSearch) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> o = cq.from(Order.class);

        List<Predicate> criteria = new ArrayList<Predicate>();

        if (orderSearch.getDeliveryStatus() != null) {
            Predicate status =
                    cb.equal(o.get("status"), orderSearch.getDeliveryStatus());
            criteria.add(status);
        }

        if (StringUtils.hasText(orderSearch.getMemberName())) {

            Join<Order, Member> m = o.join("member", JoinType.INNER);
            Predicate name =
                    cb.like(m.<String>get("name"), "%" +
                            orderSearch.getMemberName()
                            + "%");
        }

        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Order> query =
                em.createQuery(cq).setMaxResults(100);
        return query.getResultList();

    }

    public List<Order> b_findAll(){
        return em.createQuery("select 'STATUS' from  Order", Order.class)
                .getResultList();
    }
}


//        public  List<Order> findAll(OrderSearch orderSearch)
//        {
//            String jpql = "select o from "
//            em.createQuery("select  o from Order o join o.member m " +
//                    "where o.status = :status " +
//                    "and m.name like :name", Order.class)
//                    .setParameter("status", orderSearch.getDeliveryStatus())
//                    .setParameter("name", orderSearch.getMemberName())
//                    .getResultList();
//
//
//        }
//}
