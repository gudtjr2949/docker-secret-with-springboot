package common.refactoring.match.repository;

import common.refactoring.match.dto.MatchFilter;
import common.refactoring.match.dto.MatchList;
import common.refactoring.match.dto.MatchListV2;

import java.util.List;

public interface MatchRepository {
    List<MatchList> listMatchMember(MatchFilter matchFilter);
    List<MatchListV2> listMatchMemberV2();
}
