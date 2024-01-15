-- 코드를 입력하세요
SELECT ANIMAL_ID,NAME,SEX_UPON_INTAKE
from ANIMAL_INS 
where NAME = 'Lucy' ||NAME = 'Ella'||NAME = 'Pickle'||NAME = 'Rogan'||NAME = 'Sabrina'||NAME = 'Mitty'
order by ANIMAL_ID