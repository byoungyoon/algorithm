-- 코드를 입력하세요
select A.author_id AUTHOR_ID
     , C.author_name AUTHOR_NAME
     , A.category CATEGORY
     , sum(A.price * B.sales) TOTAL_SALES
from book A,
    (
    SELECT book_id, sum(sales) sales
    from book_sales
    where year(sales_date) = '2022' and month(sales_date) = '01'
    group by book_id
    ) B, author C
where A.book_id = B.book_id
  and A.author_id = C.author_id
group by C.author_name, A.category
order by A.author_id, A.category DESC