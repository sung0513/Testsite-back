package com.example.demo.service;



import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    //FIND , SAVE
    public Long SingUp(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("회원가입된 사람입니다.");
        }
    }

    @Transactional(readOnly =  true)
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Transactional(readOnly =  true)
    public Member findOne(Long memberId) {

        return memberRepository.findOne(memberId);
    }

}
