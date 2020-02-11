package testbook.testsite.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testbook.testsite.domain.Member;
import testbook.testsite.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {


    @Autowired
    MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();

    }

    public Member findOne(Long memberId) {
        return  memberRepository.findOne(memberId);
    }

}
