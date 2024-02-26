package common.refactoring.match.service;

import common.refactoring.match.dto.MatchFilter;
import common.refactoring.match.dto.MatchList;
import common.refactoring.match.dto.MatchListV2;

import java.util.List;

public interface MatchService {
    List<MatchList> listMatchMember(MatchFilter matchFilter);
    List<MatchList> listMatchMemberV2(MatchFilter matchFilter);
}
