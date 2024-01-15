-- 코드를 입력하세요
SELECT h.CAR_ID
from CAR_RENTAL_COMPANY_CAR c join CAR_RENTAL_COMPANY_RENTAL_HISTORY h
on c.CAR_ID = h.CAR_ID
where CAR_TYPE = '세단' and date_format(START_DATE,'%Y-%m') = '2022-10'
group by CAR_ID
order by CAR_ID desc