# 영화 웡카의 영화 정보를 검색하는 쿼리(배우x, 감독x, 제작국가x, 장르x)
select * from movie where mo_title = '웡카';

# 영화 웡카에 출연한 배우 및 감독을 조회하는 쿼리
SELECT 
    mo_title AS 제목, ch_name AS 이름, mp_role AS 구분
FROM
    movie
		JOIN
    `join` ON jo_mo_num = mo_num
        JOIN
    movie_person ON mp_num = jo_mp_num
        JOIN
    `character` ON mp_ch_num = ch_num
WHERE
    mo_title = '웡카';