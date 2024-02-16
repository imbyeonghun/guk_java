use community;

insert into member(me_id, me_name, me_pw, me_email, me_address, me_phoneNum) 
values('qwe123', 'qwe', 'qwe123', 'qwe123@naver.com', '경기도 수원시', '01012341234' );

insert into category(ca_name) values('카테고리');
select * from category;

insert into board(bo_name, bo_ca_num) 
values('자유', 1);
select * from board;

insert into post(po_bo_num, po_title, po_content, po_me_id) 
values(1, '안녕', '안녕하세요', 'qwe123');
select * from post;
select * from comment;

insert into comment(co_po_num, co_num, co_me_id, co_content)
values(1, 1, 'qwe123', '안녕하세요');

update comment set co_content = 'qweqwe2' where co_content = 'qweqwe';