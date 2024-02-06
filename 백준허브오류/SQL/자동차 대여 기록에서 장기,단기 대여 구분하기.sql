-- 코드를 입력하세요
SELECT HISTORY_ID,CAR_ID,date_format(START_DATE,'%Y-%m-%d') as START_DATE, date_format(END_DATE,'%Y-%m-%d') as END_DATE, if(datediff(END_DATE,START_DATE)+1>=30,'장기 대여','단기 대여') as RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where date_format(START_DATE,'%Y-%m') = '2022-09' 
order by HISTORY_ID desc
