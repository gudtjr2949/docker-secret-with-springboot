package common.refactoring.match.repository.mybatis;

import common.refactoring.match.dto.MatchFilter;
import common.refactoring.match.dto.MatchList;
import common.refactoring.match.dto.MatchListV2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MatchMapper {
    List<MatchList> listMatchMember(MatchFilter matchFilter);
    List<MatchListV2> listMatchMemberV2();
}