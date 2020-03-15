package test.testactive.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import test.testactive.domain.Address;
import test.testactive.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {

        em.persist(member);

    }

    public Member findOne(Long id) {

        return em.find(Member.class, id);

    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m" , Member.class )
                .getResultList();

    }  //member의 모든 정보를 불러오는것

    public List<Member> findByName(String name) {
        return  em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Address> b_findAll(){
        return em.createQuery("select 'STREET','ZIPCODE' from  Member", Address.class) //address에서가져오므로
                .getResultList();
    }
    // Member의 name찾아서 불러오는 것

}
