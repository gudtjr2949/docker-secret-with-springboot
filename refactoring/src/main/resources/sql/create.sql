-- member 테이블 생성
DROP TABLE IF EXISTS member;
CREATE TABLE member (
                        member_idx BIGINT AUTO_INCREMENT PRIMARY KEY,
                        email VARCHAR(255),
                        password VARCHAR(255),
                        name VARCHAR(255)
);

-- match_survey 테이블 생성
DROP TABLE IF EXISTS match_survey;
CREATE TABLE match_survey (
                              match_survey_idx BIGINT AUTO_INCREMENT PRIMARY KEY,
                              title VARCHAR(255)
);

-- match_tag 테이블 생성
DROP TABLE IF EXISTS match_tag;
CREATE TABLE match_tag (
                              match_tag_idx BIGINT AUTO_INCREMENT PRIMARY KEY,
                              match_survey_idx BIGINT,
                              FOREIGN KEY (match_survey_idx) REFERENCES match_survey(match_survey_idx),
                              tag VARCHAR(255)
);

-- match_answer 테이블 생성
DROP TABLE IF EXISTS match_answer;
CREATE TABLE match_answer (
                              match_answer_idx BIGINT AUTO_INCREMENT PRIMARY KEY,
                              member_idx BIGINT,
                              FOREIGN KEY (member_idx) REFERENCES member(member_idx),
                              match_survey_idx BIGINT,
                              FOREIGN KEY (match_survey_idx) REFERENCES match_survey(match_survey_idx),
                              match_tag_idx BIGINT,
                              FOREIGN KEY (match_tag_idx) REFERENCES match_tag(match_tag_idx),
);