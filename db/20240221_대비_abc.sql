# 계정명이 def, 비번이 def이고 내부(localhost)에서만 접근 가능한 계정을 생성하는 쿼리
CREATE USER 'def'@'localhost' identified by 'def';

select * from mysql.user;