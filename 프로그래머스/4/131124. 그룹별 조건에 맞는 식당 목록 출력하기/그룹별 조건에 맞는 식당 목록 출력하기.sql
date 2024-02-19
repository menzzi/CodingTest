-- 코드를 입력하세요
SELECT MEMBER_NAME,REVIEW_TEXT,DATE_FORMAT(REVIEW_DATE,'%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE m JOIN (SELECT MEMBER_ID,REVIEW_TEXT,REVIEW_DATE
                            FROM REST_REVIEW
                            WHERE MEMBER_ID = (SELECT MEMBER_ID 
                                               FROM REST_REVIEW 
                                               GROUP BY MEMBER_ID
                                               ORDER BY count(*) DESC
                                               limit 1)
                           ) r on m.MEMBER_ID=r.MEMBER_ID
ORDER BY REVIEW_DATE,REVIEW_TEXT