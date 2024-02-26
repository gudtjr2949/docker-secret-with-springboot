package common.refactoring.member.repository;

import common.refactoring.member.dto.Member;
import common.refactoring.member.repository.mybatis.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberMapper memberMapper;

    @Override
    public Member findMemberByMemberIdx(Long memberIdx) {
        return memberMapper.findMemberByMemberIdx(memberIdx).get();
    }

    @Override
    public List<Member> findAllMember() {
        return memberMapper.findAllMember();
    }
}