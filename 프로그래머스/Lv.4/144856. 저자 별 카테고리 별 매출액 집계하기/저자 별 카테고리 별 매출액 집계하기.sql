-- 코드를 입력하세요
SELECT b.AUTHOR_ID,a.AUTHOR_NAME,b.CATEGORY,sum(bs.SALES * b.PRICE) as TOTAL_SALES
from BOOK_SALES bs join BOOK b on bs.BOOK_ID = b.BOOK_ID
join AUTHOR a on b.AUTHOR_ID = a.AUTHOR_ID
where date_format(bs.SALES_DATE,'%Y-%m') = '2022-01'
group by b.AUTHOR_ID,b.CATEGORY
order by b.AUTHOR_ID,b.CATEGORY desc