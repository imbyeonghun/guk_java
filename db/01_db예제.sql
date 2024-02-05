/* 여러 줄 주석
-- create database if not exists test;	 -- 한줄 주석
-- create schema if not exists `test`;
# drop database if exists test;		 # 한줄 주석
# drop schema if exists `test`;
*/

drop database if exists test;

create database if not exists test;

use test;

drop table if exists member;
create table if not exists member(
	ID varchar(13) primary key,
    PW varchar(15) not null,
    email varchar(30) not null unique
);
desc member;

drop table if exists board;

create table if not exists board(
	num int auto_increment,
    title varchar(50) not null,
    content longtext not null,
    `view` int not null default 0,
    ID varchar(13) not null,
    primary key(num),
    foreign key(ID) references member(ID)
);
desc board;

use test;

# member 테이블에 가입일 컬럼을 추가
alter table member add date datetime not null;

# member 테이블에 가입일을 의미하는 date를 rdg_date 컬럼으로 변경
alter table member change date reg_date datetime not null;

# member 테이블에 불필요한 컬럼 count 추가
alter table member add count int not null;

# member 테이블에서 count 컬럼을 삭제
alter table member drop count;



