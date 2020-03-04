package test.testactive.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import test.testactive.domain.Address;
import test.testactive.domain.Delivery;

import javax.persistence.EntityManager;


@RequiredArgsConstructor
@Repository
public class AddressRepository {
        private final EntityManager em;
        public void save(Address address) {
                em.persist(address);
        }

        public Address findOne(Long Id){return em.find(Address.class, Id);}

}
