-- 코드를 입력하세요
SELECT ri.FOOD_TYPE, ri.REST_ID, ri.REST_NAME, ri.FAVORITES FROM REST_INFO ri
WHERE FAVORITES = (SELECT MAX(FAVORITES) FROM REST_INFO WHERE FOOD_TYPE = ri.FOOD_TYPE GROUP BY FOOD_TYPE) ORDER BY FOOD_TYPE DESC
