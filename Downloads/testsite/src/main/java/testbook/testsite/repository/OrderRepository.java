package testbook.testsite.repository;


import org.springframework.stereotype.Repository;
import testbook.testsite.domain.Member;
import testbook.testsite.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderRepository {


        @PersistenceContext
        private EntityManager em;

        public void save(Order order) {
                em.persist(order);
        }
        //주문 저장

        public Order find(Long id) {
                return em.find(Order.class, id);
        }

        // 주문 상태 확인


        public List<Order> findAll() {
                return em.createQuery("select o from Order o", Order.class)
                        .getResultList();
        }

        public List<Member> findByName(String name) {
                return em.createQuery("select m from Member m where m.name = :name",
                        Member.class)
                        .setParameter("name", name)
                        .getResultList();
        }
}

