package common.refactoring.match.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MatchFilter {
    private long memberIdx;
    private List<MatchOption> matchOption; // member 가 원하는 유저 필터 항목
}
