package common.refactoring.member.repository.mybatis;


import common.refactoring.member.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    Optional<Member> findMemberByMemberIdx(@Param("memberIdx") Long memberIdx);
    List<Member> findAllMember();
}
