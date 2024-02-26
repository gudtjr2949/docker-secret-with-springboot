package common.refactoring.match.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MatchListV2 {
    private long memberIdx;
    private long matchSurveyIdx;
    private long matchTagIdx;
}
