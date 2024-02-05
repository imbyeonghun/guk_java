# 대학생 관리 프로그램 물리적 설계

# DB 생성
drop database if exists university;
create database if not exists university;

USE university;

# student 테이블 삭제 후 생성
drop table if exists student;
create table if not exists student(
	st_num char(10) primary key,
    st_name varchar(30) not null,
    st_major varchar(15) not null,
    st_grade int not null default 1
);

# professor 테이블 삭제 후 생성
drop table if exists professor;
create table if not exists professor(
	pr_num char(10) primary key,
    pr_name varchar(30) not null,
    pr_room varchar(100),
    pr_major varchar(15) not null
);

# lecture 테이블 삭제 후 생성
drop table if exists lecture;
create table if not exists lecture(
	le_num int primary key auto_increment,
    le_title varchar(30) not null,
    le_room varchar(20),
    le_schedule varchar(50) not null,
    le_point int not null default 0,
    le_time int not null default 0,
    le_pr_num char(10),
    FOREIGN KEY (le_pr_num) REFERENCES professor(pr_num)
);

# course 테이블 삭제 후 생성
drop table if exists course;
create table if not exists course(
	co_num int primary key auto_increment,
    co_st_num char(10) not null,
    co_le_num int not null,
    foreign key (co_st_num) references student(st_num),
    foreign key (co_le_num) references lecture(le_num)
);

# contact 테이블 삭제 후 생성
drop table if exists contact;
create table if not exists contact(
	ct_st_num char(10) primary key,
    ct_phone varchar(13) not null,
    ct_addr varchar(30) not null,
    ct_detail varchar(30) not null default "",
    foreign key(ct_st_num) references student(st_num)
);