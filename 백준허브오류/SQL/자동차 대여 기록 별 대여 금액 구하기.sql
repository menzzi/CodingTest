-- 코드를 입력하세요
SELECT HISTORY_ID, round(sum(DAILY_FEE * (datediff(END_DATE,START_DATE)+1)*(1-ifnull(DISCOUNT_RATE,0)/100)),0) as FEE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
left join CAR_RENTAL_COMPANY_CAR c on h.CAR_ID = c.CAR_ID 
left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on c.CAR_TYPE = p.CAR_TYPE and DURATION_TYPE = (case when (datediff(END_DATE,START_DATE)+1) between 7 and 29 then "7일 이상" 
when (datediff(END_DATE,START_DATE)+1) between 30 and 89 then "30일 이상" 
when (datediff(END_DATE,START_DATE)+1)>=90 then "90일 이상" 
else null end)
where c.CAR_TYPE = "트럭"
group by HISTORY_ID
order by FEE desc, HISTORY_ID desc
