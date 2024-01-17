-- 코드를 입력하세요
SELECT YEAR(SALES_DATE) as YEAR, MONTH(SALES_DATE) as MONTH, GENDER, count(distinct(o.USER_ID)) as USERS
from USER_INFO u join ONLINE_SALE o on u.USER_ID = o.USER_ID
where GENDER is not null
group by YEAR, MONTH, GENDER
order by YEAR, MONTH, GENDER