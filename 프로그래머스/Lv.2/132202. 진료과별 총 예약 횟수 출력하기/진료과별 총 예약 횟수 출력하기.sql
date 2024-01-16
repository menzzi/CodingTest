-- 코드를 입력하세요
SELECT MCDP_CD as 진료과코드, count(*) as 5월예약건수
from APPOINTMENT
where date_format(APNT_YMD,'%Y-%m') = '2022-05'
group by 진료과코드
order by 5월예약건수,진료과코드