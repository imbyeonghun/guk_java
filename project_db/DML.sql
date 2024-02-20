use community;

insert into category(ca_title) values('카테고리');
insert into category(ca_title) values('카테고리2');
select * from category;

insert into board(bo_name, bo_ca_num) 
values('자유', 1);
select * from board;

insert into post(po_bo_num, po_title, po_content, po_me_id) 
values(1, '안녕', '안녕하세요', 'qwe123');
select * from post;
select * from `comment`;
select * from `board`;

insert into comment(co_po_num,  co_me_id, co_content)
values(1, 'qwe123', '안녕하세요');

update comment set co_content = 'qweqwe2' where co_content = 'qweqwe';

insert into board(bo_name, bo_ca_num) 
values('놀이', 1);