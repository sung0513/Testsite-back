package com.example.demo.ServiceTest;


import com.example.demo.domain.Address;
import com.example.demo.domain.Coupon;
import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.demo.domain.Coupon.천원;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    public void Insert_Test() throws Exception {
        String name = "현우";
        String street = "서울시";
        String zipcode ="강남구";
        Address address = new Address(zipcode,street);

        memberRepository.save(Member.builder()
                .name(name)
                .address(address)
                .coupon(천원)
                .build());


        List<Member> mm = memberRepository.findAll();
        System.out.println(memberRepository.findOne(mm.get(0).getId()));
        Member member = mm.get(0);
        System.out.println(member.getCreatedDate());
        assertThat(member.getName()).isEqualTo(name);
        assertThat(member.getCoupon()).isEqualTo(천원);
    }


    @Test(expected = IllegalStateException.class)
    public void Test_overlap() throws Exception {

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

}
