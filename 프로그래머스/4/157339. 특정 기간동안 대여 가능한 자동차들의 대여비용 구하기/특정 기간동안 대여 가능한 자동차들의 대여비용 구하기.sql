-- 코드를 입력하세요
SELECT CAR_ID, C.CAR_TYPE, FLOOR(30 * DAILY_FEE * (100 - DISCOUNT_RATE)/100) AS FEE
FROM CAR_RENTAL_COMPANY_CAR C JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON C.CAR_TYPE = P.CAR_TYPE
WHERE (C.CAR_TYPE = '세단' OR C.CAR_TYPE = 'SUV') 
AND CAR_ID NOT IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE <= '2022-11-30' AND END_DATE >= '2022-11-01'
) AND DURATION_TYPE = '30일 이상' 
HAVING FEE BETWEEN 500000 AND 2000000
ORDER BY FEE DESC,CAR_TYPE, CAR_ID DESC