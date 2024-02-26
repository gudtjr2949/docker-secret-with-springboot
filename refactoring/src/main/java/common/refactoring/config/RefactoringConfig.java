package common.refactoring.config;

import common.refactoring.match.repository.MatchRepository;
import common.refactoring.match.repository.MatchRepositoryImpl;
import common.refactoring.match.repository.mybatis.MatchMapper;
import common.refactoring.match.service.MatchService;
import common.refactoring.match.service.MatchServiceImpl;
import common.refactoring.member.repository.MemberRepository;
import common.refactoring.member.repository.MemberRepositoryImpl;
import common.refactoring.member.repository.mybatis.MemberMapper;
import common.refactoring.member.service.MemberService;
import common.refactoring.member.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RefactoringConfig {

    private final MemberMapper memberMapper;
    private final MatchMapper matchMapper;


    @Bean
    public MatchService matchService() {
        return new MatchServiceImpl(matchRepository(), memberRepository());
    }

    @Bean
    public MatchRepository matchRepository() {
        return new MatchRepositoryImpl(matchMapper);
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepositoryImpl(memberMapper);
    }

}
