# 계정명이 abc, 비번이 abc이고 내부(localhost)에서만 접근 가능한 계정을 생성하는 쿼리
CREATE USER 'abc'@'localhost' identified by 'abc';

# mysql에 연결된 계정 출력
select * from mysql.user;

# abc 계정에 모든 DB에 접근하는 권한을 부여
grant all privileges on account.* to 'abc'@'localhost';

# 각 DB별 사용자 계정 권한을 조회하는 쿼리
# 모든 DB에 접근 권한이 있을 경우 결과에 출력되지 않는다
select * from mysql.db;

# abc계정에 계정 생성 권한만 부여
grant create user on *.* to 'abc'@'localhost';

# MySQL에서는 AND 연산자가 OR 연산자보다 우선 순위가 높다
# A OR B AND C와 (A OR B ) AND C는 결과값이 다름

# 제품명에 A라는 글자가 포함된 제품을 조회하는 쿼리
USE shoppingmall;
SELECT 
    *
FROM
    PRODUCT
WHERE
    PR_TITLE LIKE '%우%';
    
# 제품명에 '%'라는 글자가 포함된 제품을 조회하는 쿼리
# %를 문자로 인식하게 하려면 % 앞에 \를 붙임
SELECT 
    *
FROM
    PRODUCT
WHERE
    PR_TITLE LIKE '%\%%';
    
# 제품 가격순으로 순위를 추가해서 조회
SELECT row_number() OVER(ORDER BY PR_PRICE DESC) AS '순위' ,PRODUCT.* FROM PRODUCT;

# 제품 가격순으로 순위를 추가해서 3위까지 조회
SELECT * FROM
(SELECT row_number() OVER(ORDER BY PR_PRICE DESC) AS '순위' ,PRODUCT.* FROM PRODUCT)
AS PRODUCT_TMP WHERE 순위 <= 3;

# 각 카테고리별 제품 가격 평균을 조회
SELECT PR_CA_NUM AS 카테고리, FLOOR(AVG(PR_PRICE)) AS 가격평균 FROM PRODUCT GROUP BY PR_CA_NUM;

# 각 카테고리별 제품 가격 평균이 6500원 이상인 카테고리를 조회하는 쿼리
SELECT * FROM
(SELECT PR_CA_NUM AS 카테고리, FLOOR(AVG(PR_PRICE)) AS 가격평균 FROM PRODUCT GROUP BY PR_CA_NUM)
AS AVG_PRICE WHERE 가격평균 >= 6500;

SELECT PR_CA_NUM AS 카테고리, FLOOR(AVG(PR_PRICE)) AS 가격평균 FROM PRODUCT 
GROUP BY PR_CA_NUM
HAVING 가격평균 >= 6500;

CREATE TABLE M(
	ID VARCHAR(10) PRIMARY KEY,
    PW VARCHAR(20) NOT NULL
);

CREATE TABLE B(
	NUM INT PRIMARY KEY,
    TITLE TEXT,
    ID VARCHAR(10)
);

INSERT INTO M VALUES('ABC123', 'ABC123');
INSERT INTO B VALUES(1, '제목1', 'ABC123');

SELECT * FROM B JOIN M ON M.ID = B.ID;

# B 테이블에 ID가 있고, A테이블에 ID가 있을 때 USING을 이용
# 속성 이름이 같고, 타입이 같을 때
SELECT * FROM B JOIN M USING(ID);







