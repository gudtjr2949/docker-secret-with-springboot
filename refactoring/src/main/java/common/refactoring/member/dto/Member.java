package common.refactoring.member.dto;

import lombok.Data;

@Data
public class Member {
    private long memberIdx;
    private String email;
    private String password;
    private String name;
}
