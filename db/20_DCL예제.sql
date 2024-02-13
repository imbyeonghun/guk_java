# 사용자 추가
CREATE USER 'byeonghun'@'%' IDENTIFIED BY 'abc123';

# 사용자 비밀번호 변경
SET PASSWORD FOR 'byeonghun'@'%' = 'def123';

# 사용자 삭제
DROP USER 'byeonghun'@'%';

# 현재 등록된 사용자와 사용자의 localhost 조회
SELECT USER, HOST FROM MYSQL.USER;

# GRANT 권한종류 ON DB명.테이블명 to '사용자명'@'호스트명';
GRANT ALL PRIVILEGES ON `SHOPPINGMALL`.PRODUCT TO 'byeonghun'@'%';

# 권한 제거
REVOKE ALL PRIVILEGES ON `SHOPPINGMALL`.PRODUCT FROM 'byeonghun'@'%';

GRANT ALL PRIVILEGES ON `SHOPPINGMALL`.* TO 'byeonghun'@'%';