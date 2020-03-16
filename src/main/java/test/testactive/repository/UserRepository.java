package test.testactive.repository;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test.testactive.domain.Comment;
import test.testactive.domain.user.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class UserRepository {

    @PersistenceContext
    private final EntityManager em;

    public void save(User user) {

        em.persist(user);

    }

    public User findOne(Long id) {

        return em.find(User.class, id);

    }

    public List<User> findAll() {
        return em.createQuery("select m from User m" , User.class )
                .getResultList();

    }
}
