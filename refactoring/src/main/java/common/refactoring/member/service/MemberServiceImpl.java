package common.refactoring.member.service;

import common.refactoring.member.dto.Member;
import common.refactoring.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member findMemberByMemberIdx(Long memberIdx) {
        return memberRepository.findMemberByMemberIdx(memberIdx);
    }
}
