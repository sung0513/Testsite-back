package testbook.testsite.repository;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrderRepository {


        @PersistenceContext
        private EntityManager em;
}
