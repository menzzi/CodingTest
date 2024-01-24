-- 코드를 입력하세요
SELECT YEAR(SALES_DATE) as YEAR, MONTH(SALES_DATE) as MONTH,count(distinct(o.USER_ID)) as PUCHASED_USERS, 
round(count(distinct(o.USER_ID))/(select count(*) 
                           from USER_INFO 
                           where YEAR(JOINED)=2021),1)as PUCHASED_RATIO
from USER_INFO i join ONLINE_SALE o on i.USER_ID = o.USER_ID
where YEAR(JOINED)= 2021
group by YEAR,MONTH
order by YEAR,MONTH