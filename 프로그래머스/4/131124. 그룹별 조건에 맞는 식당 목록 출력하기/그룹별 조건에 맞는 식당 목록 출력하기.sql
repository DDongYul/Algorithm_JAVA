-- 코드를 입력하세요
# SELECT *
# FROM MEMBER_PROFILE M
# JOIN REST_REVIEW R
# ON M.MEMBER_ID = R.MEMBER_ID
# WHERE M.MEMBER_ID = ((SELECT MAX(*), MEMBER_ID
#                         FROM REST_REVIEW
#                         GROUP BY MEMBER_ID))


# SELECT MAX(review_count)
# FROM (
#     SELECT COUNT(*) AS review_count
#     FROM REST_REVIEW
#     GROUP BY MEMBER_ID
# ) AS review_counts;

SELECT M.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE M
JOIN REST_REVIEW R
ON M.MEMBER_ID = R.MEMBER_ID
WHERE R.MEMBER_ID = (SELECT MEMBER_ID
FROM REST_REVIEW
GROUP BY MEMBER_ID
ORDER BY COUNT(*) DESC
LIMIT 1)
ORDER BY R.REVIEW_DATE ASC, R.REVIEW_TEXT ASC ;