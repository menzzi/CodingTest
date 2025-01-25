SELECT II.ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO II
JOIN (SELECT IT2.ITEM_ID FROM ITEM_TREE IT2 JOIN ITEM_INFO II2 ON IT2.PARENT_ITEM_ID = II2.ITEM_ID WHERE II2.RARITY = 'RARE') IT ON II.ITEM_ID = IT.ITEM_ID
ORDER BY ITEM_ID DESC