WITH TargetCars AS (
    -- 1단계: 2022년 8월부터 10월까지 총 대여 횟수가 5회 이상인 CAR_ID를 찾습니다.
    SELECT
        CAR_ID
    FROM
        CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE
        -- 대여 시작일이 2022년 8월 1일부터 2022년 10월 31일 사이인 기록만 필터링
        START_DATE >= '2022-08-01' AND START_DATE <= '2022-10-31'
    GROUP BY
        CAR_ID
    HAVING
        COUNT(HISTORY_ID) >= 5
)

-- 2단계: 1단계에서 찾은 자동차들에 대해 월별, 자동차 ID별 대여 횟수를 계산합니다.
SELECT
    -- 날짜에서 '월'만 추출하고 정수로 변환합니다. (MySQL 기준, 다른 DBMS는 적절히 변경)
    CAST(DATE_FORMAT(START_DATE, '%m') AS UNSIGNED) AS MONTH,
    CRHR.CAR_ID,
    COUNT(CRHR.HISTORY_ID) AS RECORDS
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY CRHR
JOIN
    TargetCars TC ON CRHR.CAR_ID = TC.CAR_ID
WHERE
    -- 1단계와 동일하게 2022년 8월부터 10월까지의 기록만 사용합니다.
    CRHR.START_DATE >= '2022-08-01' AND CRHR.START_DATE <= '2022-10-31'
GROUP BY
    MONTH,
    CRHR.CAR_ID
ORDER BY
    MONTH ASC,  -- 월을 기준으로 오름차순 정렬
    CRHR.CAR_ID DESC; -- 월이 같다면 자동차 ID를 기준으로 내림차순 정렬