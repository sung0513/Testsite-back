package test.testactive.service;


import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
import static test.testactive.domain.DeliveryStatus.ARRIVE;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;



    @Test
    public void testmember() throws Exception {

        String street = "서울시";
        String zipcode ="강남구";
        Address address = new Address(zipcode,street);

        Member member = new Member();
        member.setName("zz");
        member.setAddress(address);
        member.setCoupon(천원);


        System.out.printf("주소 %s", member.getAddress());
        Long saveId = memberService.SingUp(member);
        assertEquals(member, memberRepository.findOne(saveId));
    }




    @Test(expected = IllegalStateException.class)
    public void testCheckmember() throws Exception {

        Member member1 = new Member();
        member1.setName("pizza");
        Member member2 = new Member();
        member2.setName("checck");

        memberService.SingUp(member1);
        memberService.SingUp(member2);
        fail("예외가 발생해야 한다.");
    }

    @Test
    public void input_BaseTimeEntity(){
        //given
        LocalDateTime now = LocalDateTime.of(2020,2,17,0,0,0);
        Member member1 = new Member();
        member1.setName("pizza");
        Member member2 = new Member();
        member2.setName("aa");


        List<Member> MemberList = memberRepository.findAll();

        Member member = MemberList.get(0);

        System.out.println(">>>>>>>>>>>>> createDate = "+member.getCreatedDate()+", modifiedDate =" + member.getModifiedDate());

        assertThat(member.getCreatedDate()).isAfter(now);
        assertThat(member.getModifiedDate()).isAfter(now);
    }


}