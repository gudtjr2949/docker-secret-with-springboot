package common.refactoring.member.service;

import common.refactoring.member.dto.Member;

public interface MemberService {
    Member findMemberByMemberIdx(Long memberIdx);
}
