SELECT ID, 
CASE WHEN SIZE_OF_COLONY <=100 THEN 'LOW' 
WHEN SIZE_OF_COLONY BETWEEN 101 AND 1000 THEN 'MEDIUM'
WHEN SIZE_OF_COLONY >1000 THEN 'HIGH' END AS SIZE
FROM ECOLI_DATA
ORDER BY ID;
