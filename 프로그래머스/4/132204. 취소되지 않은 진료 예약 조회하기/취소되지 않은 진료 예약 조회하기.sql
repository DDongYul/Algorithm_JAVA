WITH PDA AS (
    SELECT A.APNT_NO, P.PT_NAME, P.PT_NO, A.MCDP_CD, D.DR_NAME, A.APNT_YMD, A.APNT_CNCL_YN
    FROM APPOINTMENT A
    JOIN DOCTOR D
    ON A.MDDR_ID = D.DR_ID
    JOIN PATIENT P
    ON A.PT_NO = P.PT_NO
)

SELECT APNT_NO, PT_NAME, PT_NO, MCDP_CD, DR_NAME, APNT_YMD
FROM PDA
WHERE DATE_FORMAT(APNT_YMD, '%Y-%m-%d') = '2022-04-13' AND APNT_CNCL_YN = 'N'
ORDER BY APNT_YMD
