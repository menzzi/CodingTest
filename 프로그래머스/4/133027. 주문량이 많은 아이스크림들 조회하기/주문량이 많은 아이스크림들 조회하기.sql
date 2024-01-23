-- 코드를 입력하세요
with T as(
    select *
    from FIRST_HALF
    
    union all
    
    select *
    from JULY
)


SELECT FLAVOR
from T
group by FLAVOR
order by sum(TOTAL_ORDER) desc
limit 3