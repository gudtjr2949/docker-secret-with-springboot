package common.refactoring.match.repository;

import common.refactoring.match.dto.MatchFilter;
import common.refactoring.match.dto.MatchList;
import common.refactoring.match.dto.MatchListV2;
import common.refactoring.match.repository.mybatis.MatchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MatchRepositoryImpl implements MatchRepository {

    private final MatchMapper matchMapper;

    @Override
    public List<MatchList> listMatchMember(MatchFilter matchFilter) {
        return matchMapper.listMatchMember(matchFilter);
    }

    @Override
    public List<MatchListV2> listMatchMemberV2() {
        return matchMapper.listMatchMemberV2();
    }
}
