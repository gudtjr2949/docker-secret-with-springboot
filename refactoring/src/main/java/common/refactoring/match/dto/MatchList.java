package common.refactoring.match.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MatchList {
    private long memberIdx;
    private String name;
    private double percent;
}