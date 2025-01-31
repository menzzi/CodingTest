SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR, (SIZE - SIZE_OF_COLONY) AS YEAR_DEV, ID
FROM ECOLI_DATA ED JOIN (
    SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR, MAX(SIZE_OF_COLONY) AS SIZE 
    FROM ECOLI_DATA 
    GROUP BY YEAR) ED2 
ON YEAR(ED.DIFFERENTIATION_DATE) = ED2.YEAR
ORDER BY YEAR, YEAR_DEV
