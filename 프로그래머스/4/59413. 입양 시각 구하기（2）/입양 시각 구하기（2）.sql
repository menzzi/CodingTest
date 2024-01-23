-- 코드를 입력하세요
with recursive H as(
    select 0 as HOUR 
    union all
    select HOUR +1 from H where HOUR <23
)

SELECT HOUR as HOUR, count(ANIMAL_ID) as COUNT
from H h left join ANIMAL_OUTS o on h.HOUR = hour(o.DATETIME)
group by h.HOUR