/*
테이블명만 쓰는 것과 DB명.테이블명을 쓰는 것의 차이
- 테이블명만 쓰는 경우는 내가 작업하려는 DB가 선택됐을 때
- DB명.테이블명은 현재 선택된 DB와 상관없이 작업할 수 있다

insert into 테이블명() values();
테이블명() 안에 들어가지 않은 속성은 null값이 들어감
*/
use world;

use test;

# 테이블에 등록된 컬럼 순서에 상관없이 추가할 때 나열한 컬럼 순서대로 값들을 넣어주면 됨
insert into `member`(id,pw,email,reg_date) values("abc", "def", "abc@naver.com", now());
insert into `member`(pw,id,reg_date,email) values("pw123", "id1", now(), "id1@naver.com");

# 속성명을 생략한 대신 테이블에 등록된 컬럼 순서대로 값들을 넣어줘야 함
insert into member values("id2","비번입니다","id2@naver.com",now());

# now()를 이용해서 날짜를 문자열에 저장하면 날짜가 문자열로 변환되서 오류가 안남
# 날짜형태가 아닌 문자열을 datetime에 저장하려하면 오류 발생
# insert into member values("id3","비번입니다",now(),"id3@naver.com");

# 날짜 형태인 문자열을 datetime에 저장하려하면 변환이 가능하기 때문에 정상 동작
insert into member values("id3","비번입니다",now(),"2024-02-01 16:25:00");

# 조건에서 같다 => =, 같지 않다 => != 또는 <>으로 사용
# 아이디가 id3인 회원의 이메일을 id3@naver.com으로 수정하는 쿼리
update
	member 
set 
	email = "id3@naver.com" 
where 
	id = "id3";

# 아이디가 id1인 회원의 비번을 idabc로, 이메일을 idabc@naver.com으로 수정하는 쿼리
update
	member
set 
	pw = "idabc",
    email = "idabc@naver.com"
where
	id = "id1";
    
# 아이디가 abc인 회원의 정보를 삭제하는 쿼리
delete 
from
	member
where
	id = "abc";

# member 테이블을 조회
select * from member;

# id가 id1인 회원의 정보를 조회
select * from member where id = "id1";
USE TEST;
# 가입된 회원 전체를 조회
SELECT 
    *
FROM
    MEMBER;
    
# 아이디가 ID1인 회원의 정보를 조회 
SELECT 
    *
FROM
    MEMBER
WHERE
    ID = 'ID1';
# 모든 회원의 아이디와 이메일을 조회 
SELECT 
    ID, EMAIL
FROM
    MEMBER;
# 24년도에 가입한 회원을 조회
SELECT 
    *
FROM
    MEMBER
WHERE
    REG_DATE LIKE '2024-%';
# 이메일이 네이버인 회원을 조회 
SELECT 
    *
FROM
    MEMBER
WHERE
    EMAIL LIKE '%_@NAVER.COM';






