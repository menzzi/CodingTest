SELECT AO.ANIMAL_ID, AO.NAME
FROM ANIMAL_OUTS AO LEFT JOIN ANIMAL_INS AI ON AO.ANIMAL_ID = AI.ANIMAL_ID
WHERE AI.ANIMAL_ID IS NULL
ORDER BY ANIMAL_ID