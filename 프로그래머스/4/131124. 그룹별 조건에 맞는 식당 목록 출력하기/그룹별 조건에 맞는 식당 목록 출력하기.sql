-- 코드를 입력하세요
SELECT MEMBER_NAME,REVIEW_TEXT,date_format(REVIEW_DATE,'%Y-%m-%d') as REVIEW_DATE
from MEMBER_PROFILE p join 
(select MEMBER_ID,REVIEW_TEXT,REVIEW_DATE
from REST_REVIEW
where MEMBER_ID = (
        select MEMBER_ID
        from REST_REVIEW
        group by MEMBER_ID
        order by count(*) desc
        limit 1
    )
) r on p.MEMBER_ID=r.MEMBER_ID
order by REVIEW_DATE,REVIEW_TEXT