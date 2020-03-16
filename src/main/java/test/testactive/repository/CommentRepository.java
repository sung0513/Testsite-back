package test.testactive.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test.testactive.domain.Address;
import test.testactive.domain.Comment;
import test.testactive.domain.Member;
import test.testactive.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor

public class CommentRepository {
        @PersistenceContext
        private final EntityManager em;

        public void save(Comment comment) {

            em.persist(comment);

        }

        public Comment findOne(Long id) {

            return em.find(Comment.class, id);

        }

        public List<Comment> findAll() {
            return em.createQuery("select m from Comment m" , Comment.class )
                    .getResultList();

        }


}

