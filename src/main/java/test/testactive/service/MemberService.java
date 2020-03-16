package test.testactive.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.testactive.domain.Member;
import test.testactive.repository.MemberRepository;
import test.testactive.response.AddressListResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service

@RequiredArgsConstructor
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

    @Transactional(readOnly = true)
    public List<AddressListResponseDto> b_findMembers() {
        return memberRepository.b_findAll().stream().map(AddressListResponseDto::new).collect(Collectors.toList()
        );
    }

}



