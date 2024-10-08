-- 코드를 입력하세요
SELECT b.category as CATEGORY, SUM(bs.sales) as TOTAL_SALES FROM book_sales bs JOIN book b ON bs.book_id = b.book_id WHERE bs.sales_date >= '2022-01-01' AND bs.sales_date <= '2022-01-31' GROUP BY CATEGORY ORDER BY CATEGORY;
