-- 코드를 입력하세요
SELECT h.FLAVOR
from FIRST_HALF h , ICECREAM_INFO i
where h.FLAVOR = i.FLAVOR and TOTAL_ORDER>3000 and INGREDIENT_TYPE ='fruit_based'
order by TOTAL_ORDER desc
