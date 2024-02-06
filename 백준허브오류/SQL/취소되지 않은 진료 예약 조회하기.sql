-- 코드를 입력하세요
SELECT a.APNT_NO,p.PT_NAME,p.PT_NO,a.MCDP_CD,d.DR_NAME,a.APNT_YMD
from APPOINTMENT a join PATIENT p on a.PT_NO = p.PT_NO
join DOCTOR d on a.MDDR_ID = d.DR_ID
where a.MCDP_CD = 'CS' and APNT_CNCL_YN != 'Y' and date_format(a.APNT_YMD,'%Y-%m-%d') = '2022-04-13'
order by APNT_YMD
