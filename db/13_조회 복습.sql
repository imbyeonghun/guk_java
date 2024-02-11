use university;

# 컴퓨터 공학을 다니는 학생 정보를 조회 (O)
select * from student where st_major = "컴퓨터공학";


# 컴퓨터공학을 다니는 1학년 학생 정보를 조회 (O)
select * from student where st_major = "컴퓨터공학" and st_grade = 1;


# 컴퓨터 공학 또는 화학공학을 다니는 1학년 학생 정보를 조회 (O)
select * from student where (st_major = "컴퓨터공학" or st_major = "화학공학") and st_grade = 1;
select * from student where st_major in("컴퓨터공학","화학공학") and st_grade = 1;


# 컴퓨터공학을 다니는 학생 수를 조회 (X)
select count(*) from student where st_major = "컴퓨터공학" group by st_major;


# 학생들이 등록된 학과를 조회 (X)
# distinct : 중복 제거
select distinct st_major from student ;


# 학생들이 3명 이상 등록된 학과들을 조회 (X)
SELECT 
    st_major
FROM
    student
GROUP BY st_major
HAVING COUNT(st_num) >= 3;


# 컴퓨터개론을 수강하는 학생 수를 조회 (O)
select
	count(*)
from
	course
		join
	lecture on co_le_num = le_num 
where
	le_title = '컴퓨터개론'
group by co_le_num;
   
   
# 각 강의별 수강하는 학생수를 조회, 강의명과 학생수를 조회 (X)
select
	le_title, count(co_st_num)
from
	course
		join
	lecture on co_le_num = le_num 
group by co_le_num;


# 홍길동 학생이 수강하는 강의목록을 조회 (X)
select 
	st_name,le_title
from 
	course
		join 
	student on co_st_num = st_num
		join
	lecture on co_le_num = le_num
where st_name = '홍길동';


# 기계공학에 소속된 교수의 수를 조회 (O)
SELECT 
    COUNT(*)
FROM
    professor
WHERE
    pr_major = '기계공학';


# 김교수가 강의하는 강의명을 조회 (O)
select 
	pr_name,le_title
from 
	professor
		join
	lecture on pr_num = le_pr_num
where
	pr_name = '김교수';

# -----------------------------------------

use shoppingmall;

# 모든 제품을 조회 (O)
select * from product;


# 모든 카테고리를 조회 (O)
select * from category;


# 제품별 카테고리 조회 카테고리,제품을 조회 (O)
select 
	ca_name,pr_title
from 
	product 
		join
	category on ca_num = pr_ca_num;


# 기타 카테고리에 포함된 모든 제품을 조회 (O)
SELECT 
    ca_name, product.*
FROM
    product
        JOIN
    category ON ca_num = pr_ca_num
WHERE
    ca_name = '기타';


 # abc123회원이 주문한 제품 목록을 조회 (O)
SELECT 
    or_date, or_state, or_amount, or_total_price, pr_title
FROM
    `order`
        JOIN
    product ON pr_code = or_pr_code
WHERE
    or_me_id = 'abc123';


# 제품별 판매수량을 조회 (X)
SELECT 
    product.*, IFNULL(SUM(or_amount), 0) AS '판매수량'
FROM
    `order`
        RIGHT JOIN
    product ON pr_code = or_pr_code
where or_state not in('반품','환불') or or_state is null
GROUP BY pr_code;


# 인기 제품 조회. 
# 인기 제품은 누적 판매량을 기준으로 상위 5개 제품 (X)
SELECT 
    product.*, IFNULL(SUM(or_amount), 0) AS '판매수량'
FROM
    `order`
        RIGHT JOIN
    product ON pr_code = or_pr_code
where or_state not in('반품','환불') or or_state is null
GROUP BY pr_code
order by 판매수량 desc, pr_price asc
limit 0 , 5;


# 가격이 제일 비싼 제품을 조회 (O)
SELECT 
    *
FROM
    product
ORDER BY pr_price DESC
LIMIT 0 , 1;