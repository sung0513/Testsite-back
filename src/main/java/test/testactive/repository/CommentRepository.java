package test.testactive.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.Comments;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {
        @PersistenceContext
        private final EntityManager em;

    @Transactional
    public Comments save(Comments entity){

        em.persist(entity);
        return entity; // Comment임니다.

    }

    public Comments findOne(Long id) {

        return em.find(Comments.class, id);

    }

    public List<Comments> findAll() {
        return em.createQuery("select m from Comments m" , Comments.class )
                .getResultList();

    }

    @Transactional
    public void deleteAll(){

        for(Comments element: findAll() )
            em.remove(element);
    }



}

