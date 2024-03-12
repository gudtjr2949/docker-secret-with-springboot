package common.refactoring.match.service;

import common.refactoring.match.dto.MatchFilter;
import common.refactoring.match.dto.MatchList;
import common.refactoring.match.dto.MatchListV2;
import common.refactoring.match.repository.MatchRepository;
import common.refactoring.match.service.MatchService;
import common.refactoring.member.dto.Member;
import common.refactoring.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;
    private final MemberRepository memberRepository;

    // 요청한 member 가 필터링한 항목과 일치하는 member 정보 리턴
    @Override
    public List<MatchList> listMatchMember(MatchFilter matchFilter) {
        return matchRepository.listMatchMember(matchFilter);
    }

    @Override
    public List<MatchList> listMatchMemberV2(MatchFilter matchFilter) {
        List<Member> allMember = memberRepository.findAllMember();

        // 모든 답변 가져오기
        List<MatchListV2> allMatchLists = matchRepository.listMatchMemberV2();

        List<MatchList> matchLists = new ArrayList<>();

        int[] sameCnt = new int[100001];

        for (MatchListV2 match : allMatchLists) {

            for (int i = 0; i < 6; i++) {
                if (matchFilter.getMatchOption().get(i).getMatchSurveyIdx() == match.getMatchSurveyIdx()
                        && matchFilter.getMatchOption().get(i).getMatchTagIdx() == match.getMatchTagIdx()) {
                    sameCnt[(int) match.getMemberIdx()]++;
                }
            }
        }

        for (Member member : allMember) {
            if (member.getMemberIdx() != matchFilter.getMemberIdx())
                matchLists.add(new MatchList(member.getMemberIdx(), member.getName(), (sameCnt[(int) member.getMemberIdx()]/ 6.0) * 100.0));
        }

        Collections.sort(matchLists, Comparator.comparing(MatchList::getPercent).reversed());

        return matchLists;
    }
}
