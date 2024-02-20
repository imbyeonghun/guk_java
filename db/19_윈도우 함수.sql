# 쇼핑몰을 이용한 윈도우 함수 예제

USE SHOPPINGMALL;

# 제품을 가격순으로 정렬 ROW_NUMBER
# 정렬한 거에서 순서 부여(같은 가격이여도 다른 번호로)
SELECT 
	ROW_NUMBER() OVER(ORDER BY PR_PRICE DESC) AS '순서', PRODUCT.*
FROM 
	PRODUCT;
    
    
# 제품을 가격순으로 정렬 RANK
# 정렬한 거에서 순서 부여(같은 가격이면 같은 번호로, 그 중복되는 번째 수는 건너띔)
SELECT 
	RANK() OVER(ORDER BY PR_PRICE DESC) AS '금액순', PRODUCT.*
FROM 
	PRODUCT;
    
    
# 제품을 가격순으로 정렬 DENSE_RANK
# 정렬한 거에서 순서 부여(같은 가격이면 같은 번호로, 그 중복되는 번째 수는 건너지 않고)
SELECT 
	DENSE_RANK() OVER(ORDER BY PR_PRICE DESC) AS '금액순', PRODUCT.*
FROM 
	PRODUCT;
    
    
# 제품을 비싼 제품, 싼 제품으로 정렬 NTILE
# NTILE(n) n개로 나눠서 번호 부여
SELECT 
	NTILE(2) OVER(ORDER BY PR_PRICE DESC) AS '그룹', PRODUCT.*
FROM 
	PRODUCT;
    
    
# 가장 비싼 제품들을 조회하는 쿼리 DENSE_RANK
SELECT * FROM(
	SELECT 
		DENSE_RANK() OVER(ORDER BY PR_PRICE DESC) AS 'PR_RANK', PRODUCT.*
	FROM 
		PRODUCT
) AS RANKED_PRODUCT
WHERE 
	PR_RANK = 1;