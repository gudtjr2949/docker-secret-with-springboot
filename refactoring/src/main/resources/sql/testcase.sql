-- member 테이블에 데이터 추가 (만명 추가)
INSERT INTO member (email, password, name)
SELECT CONCAT('member', number, '@example.com') AS email,
       CONCAT('password', number)               AS password,
       CONCAT('member ', number)                AS name
FROM (SELECT (ones.number + 10 * tens.number + 100 * hundreds.number) AS number
      FROM (SELECT 0 AS number
            UNION ALL
            SELECT 1
            UNION ALL
            SELECT 2
            UNION ALL
            SELECT 3
            UNION ALL
            SELECT 4
            UNION ALL
            SELECT 5
            UNION ALL
            SELECT 6
            UNION ALL
            SELECT 7
            UNION ALL
            SELECT 8
            UNION ALL
            SELECT 9) ones,
           (SELECT 0 AS number
            UNION ALL
            SELECT 1
            UNION ALL
            SELECT 2
            UNION ALL
            SELECT 3
            UNION ALL
            SELECT 4
            UNION ALL
            SELECT 5
            UNION ALL
            SELECT 6
            UNION ALL
            SELECT 7
            UNION ALL
            SELECT 8
            UNION ALL
            SELECT 9) tens,
           (SELECT 0 AS number
            UNION ALL
            SELECT 1
            UNION ALL
            SELECT 2
            UNION ALL
            SELECT 3
            UNION ALL
            SELECT 4
            UNION ALL
            SELECT 5
            UNION ALL
            SELECT 6
            UNION ALL
            SELECT 7
            UNION ALL
            SELECT 8
            UNION ALL
            SELECT 9) hundreds) AS numbers
WHERE number BETWEEN 1 AND 10000;

-- match_survey 테이블에 데이터 추가
INSERT INTO match_survey (title)
VALUES ('본인의 기술 포지션은 어디인가요?'),
       ('선호하는 프로그래밍 언어는 무엇인가요?'),
       ('거주 지역은 어디인가요?'),
       ('가장 자신있는 기술은 무엇인가요?'),
       ('현재 어떤 기술에 관심이 있나요?'),
    ('프로젝트에서 어떤 역할을 선호하시나요?');

-- match_tag 테이블에 데이터 추가
INSERT INTO match_tag (match_survey_idx, tag)
VALUES
-- 기술 포지션 질문 (매칭 survey_idx: 1)
(1, 'Backend Developer'),
(1, 'Frontend Developer'),
(1, 'Full-stack Developer'),
(1, 'Data Scientist'),
(1, 'DevOps Engineer'),
(1, 'UI/UX Designer'),
(1, 'QA Engineer');

-- 선호하는 프로그래밍 언어 질문 (매칭 survey_idx: 2)
INSERT INTO match_tag (match_survey_idx, tag)
VALUES
    (2, 'Java'), (2, 'JavaScript'), (2, 'Python'), (2, 'C'), (2, 'C++'), (2, 'Ruby'), (2, 'Go');

-- 거주 지역 질문 (매칭 survey_idx: 3)
INSERT INTO match_tag (match_survey_idx, tag)
VALUES (3, 'Seoul'),
       (3, 'New York'),
       (3, 'London'),
       (3, 'Tokyo'),
       (3, 'Sydney'),
       (3, 'Paris'),
       (3, 'Berlin');

-- 가장 자신있는 기술 질문 (매칭 survey_idx: 4)
INSERT INTO match_tag (match_survey_idx, tag)
VALUES (4, 'Spring Framework'),
       (4, 'React'),
       (4, 'Django'),
       (4, 'Machine Learning'),
       (4, 'Kubernetes'),
       (4, 'UI Design'),
       (4, 'Test Automation');

-- 현재 어떤 기술에 관심이 있나요? 질문 (매칭 survey_idx: 5)
INSERT INTO match_tag (match_survey_idx, tag)
VALUES (5, 'Kubernetes'),
       (5, 'Docker'),
       (5, 'AWS'),
       (5, 'Google Cloud'),
       (5, 'Terraform'),
       (5, 'Adobe XD'),
       (5, 'Jenkins');

-- 프로젝트에서 어떤 역할을 선호하시나요? 질문 (매칭 survey_idx: 6)
INSERT INTO match_tag (match_survey_idx, tag)
VALUES (6, 'Project Manager'),
       (6, 'Technical Lead'),
       (6, 'Software Architect'),
       (6, 'Quality Assurance Lead'),
       (6, 'Database Administrator'),
       (6, 'Scrum Master'),
       (6, 'Business Analyst');