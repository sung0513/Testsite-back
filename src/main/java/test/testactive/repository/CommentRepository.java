package test.testactive.repository;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    public Comment save(Comment entity){

        em.persist(entity);
        return entity;

    }

    public Comment findOne(Long id) {

        return em.find(Comment.class, id);

    }

    public List<Comment> findAll() {
        return em.createQuery("select m from Comment m" , Comment.class )
                .getResultList();

    }

    @Transactional
    public void deleteAll(){

        for(Comment element: findAll() )
            em.remove(element);
    }



}

