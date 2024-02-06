-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, concat(CITY," ",STREET_ADDRESS1," ",STREET_ADDRESS2) as 전체주소, concat(substring(TLNO from 1 for 3),"-",substring(TLNO from 4 for 4),"-",substring(TLNO from 8 for 4)) as 전화번호
from USED_GOODS_BOARD b join USED_GOODS_USER u on b.WRITER_ID=u.USER_ID
group by WRITER_ID having count(*) >=3
order by USER_ID desc
