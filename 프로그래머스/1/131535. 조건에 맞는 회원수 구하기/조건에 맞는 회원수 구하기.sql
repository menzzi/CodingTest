-- 코드를 입력하세요
SELECT count(USER_ID) as USERS
from USER_INFO
where AGE>=20 and AGE<=29 and YEAR(JOINED) = '2021'