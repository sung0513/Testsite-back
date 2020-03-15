package test.testactive.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.Address;
import test.testactive.domain.Member;
import test.testactive.repository.MemberRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static test.testactive.domain.Coupon.천원;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testmember() throws Exception {
        String named = "현우";
        String street = "서울시";
        String zipcode = "강남구";
        Address address = new Address(zipcode, street);
        //새로운 방식
        memberRepository.save(Member.builder()
                .name(named)
                .address(address)
                .coupon(천원)
                .build());
        List<Member> mm = memberRepository.findAll();
        Member member = mm.get(0);
        System.out.println(member.getCreatedDate());
        assertThat(member.getName()).isEqualTo(named);


        /**
         * 기존 방식 @Setter 사용
         */

    }


    @Test(expected = IllegalStateException.class)
    public void testCheckmember() throws Exception {

        memberRepository.save(Member.builder()
                .name("abc")
                .build());
        memberRepository.save(Member.builder()
                .name("abc")
                .build());
        List<Member> mm = memberRepository.findAll();
        Member member = mm.get(0);
        Member member2 = mm.get(1);
        memberService.SingUp(member);//save
        memberService.SingUp(member2); //save
        fail("예외가 발생해야 한다.");
    }

    @Test
    public void input_BaseTimeEntity() {
        //given
        LocalDateTime now = LocalDateTime.of(2020, 2, 17, 0, 0, 0);

        memberRepository.save(Member.builder()
                .name("pizza")
                .build());
        List<Member> MemberList = memberRepository.findAll();

        Member member = MemberList.get(0);

        System.out.println(">>>>>>>>>>>>> createDate = " + member.getCreatedDate() + ", modifiedDate =" + member.getModifiedDate());

        assertThat(member.getCreatedDate()).isAfter(now);
        assertThat(member.getModifiedDate()).isAfter(now);
    }
    //Rollbock(true) - > 작업 -> @Transactional
}