package common.refactoring.member.repository;

import common.refactoring.member.dto.Member;

import java.util.List;

public interface MemberRepository {
    Member findMemberByMemberIdx(Long memberIdx);
    List<Member> findAllMember();
}
