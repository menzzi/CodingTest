-- 코드를 입력하세요
SELECT c.CAR_ID
from CAR_RENTAL_COMPANY_CAR c join CAR_RENTAL_COMPANY_RENTAL_HISTORY h on c.CAR_ID = h.CAR_ID
where date_format(START_DATE,'%m') = '10' and CAR_TYPE ='세단'
group by CAR_ID
order by CAR_ID desc
