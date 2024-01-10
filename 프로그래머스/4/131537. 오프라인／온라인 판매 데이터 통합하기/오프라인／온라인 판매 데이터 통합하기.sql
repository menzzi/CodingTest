-- 코드를 입력하세요
SELECT date_format(SALES_DATE,'%Y-%m-%d') as SALES_DATE, PRODUCT_ID,USER_ID,SALES_AMOUNT
from ONLINE_SALE
where date_format(SALES_DATE,'%Y-%m') = '2022-03'


UNION ALL

SELECT date_format(SALES_DATE,'%Y-%m-%d') as SALES_DATE,PRODUCT_ID, NULL as USER_ID,SALES_AMOUNT
from OFFLINE_SALE
where date_format(SALES_DATE,'%Y-%m') = '2022-03'

order by SALES_DATE,PRODUCT_ID,USER_ID
