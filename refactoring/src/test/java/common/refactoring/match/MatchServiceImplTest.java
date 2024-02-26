//package common.refactoring.match;
//
//
//import common.refactoring.match.dto.MatchFilter;
//import common.refactoring.match.dto.MatchList;
//import common.refactoring.match.dto.MatchOption;
//import common.refactoring.match.repository.MatchRepository;
//import common.refactoring.member.dto.Member;
//import common.refactoring.member.repository.MemberRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Slf4j
//@SpringBootTest
//class MatchServiceImplTest {
//
//    @Autowired
//    MemberRepository memberRepository;
//
//    @Autowired
//    MatchRepository matchRepository;
//
//    @Test
//    void findMemberByMemberIdx() {
//        Member member = memberRepository.findMemberByMemberIdx(102L);
//        Assertions.assertThat(member.getName()).isEqualTo("member 102");
//    }
//
//    @Test
//    void findAnswerByMemberIdx() {
//        List<MatchOption> list = new ArrayList<>();
//        list.add(new MatchOption(1L, 3L));
//        list.add(new MatchOption(2L, 10L));
//        list.add(new MatchOption(3L, 15L));
//        list.add(new MatchOption(4L, 24L));
//        list.add(new MatchOption(5L, 31L));
//        list.add(new MatchOption(6L, 36L));
//        MatchFilter matchFilter = new MatchFilter(20L, list);
//
//        List<MatchList> matchLists = matchRepository.listMatchMember(matchFilter);
//
//        for (MatchList match : matchLists) {
//            System.out.println(match);
//        }
//    }
//}