package test.testactive.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test.testactive.domain.Order;
import test.testactive.domain.OrderSearch;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {



        private final EntityManager em;

        public void save(Order order) {
            em.persist(order);
        }

        public Order findOne(Long id) {
            return  em.find(Order.class, id);
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
//        }
}
