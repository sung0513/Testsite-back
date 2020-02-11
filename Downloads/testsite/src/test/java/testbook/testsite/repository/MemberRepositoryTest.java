package testbook.testsite.repository;


import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import testbook.testsite.domain.Member;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false) // 초기화 되기 때문에 롤백 막음

    public void testMember() {

        Member member = new Member();
        member.setName("test이");
        Long findOne= memberRepository.findOne(Long.member);

        Member findMember = memberRepository.findOne(Long.member);

        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());

        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());

        Assertions.assertThat(findMember).isEqualTo(member);


    }

    @Test
    public void find() {
    }
}
