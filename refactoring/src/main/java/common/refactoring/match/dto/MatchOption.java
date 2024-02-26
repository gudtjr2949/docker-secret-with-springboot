package common.refactoring.match.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MatchOption {
    private long matchSurveyIdx;
    private long matchTagIdx;
}
