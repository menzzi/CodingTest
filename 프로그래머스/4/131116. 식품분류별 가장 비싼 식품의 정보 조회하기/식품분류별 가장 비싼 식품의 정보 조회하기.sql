-- 코드를 입력하세요
SELECT CATEGORY, max(PRICE) as MAX_PRICE, PRODUCT_NAME 
from FOOD_PRODUCT
where PRICE in (
    select max(PRICE)
    from FOOD_PRODUCT
    group by CATEGORY
)
and CATEGORY regexp '과자|국|김치|식용유'
group by CATEGORY
order by MAX_PRICE desc