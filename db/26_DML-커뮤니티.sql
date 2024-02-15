USE COMMUNITY2;

# 회원 상태를 추가하는 쿼리(이용 중, 기간 정지, 영구 정지, 탈퇴)
INSERT INTO MEMBER_STATE(MS_STATE) VALUES('이용중'), ('기간정지'), ('영구정지'), ('탈퇴');

# 3명이 각각 회원 가입을 진행할 때 필요한 쿼리
# 아이디 : abc123, 비번 : abc123, 이메일 : abc123@kh.co.kr, 권한이 : USER
INSERT INTO MEMBER(ME_ID, ME_PW, ME_EMAIL, ME_MS_STATE)
VALUES('abc123', 'abc123', 'abc123@kh.co.kr', '이용중');

# 아이디 : qwe123, 비번 : qwe123, 이메일 : qwe123@kh.co.kr, 권한이 : USER
INSERT INTO MEMBER(ME_ID, ME_PW, ME_EMAIL, ME_MS_STATE)
VALUES('qwe123', 'qwe123', 'qwe123@kh.co.kr', '이용중');

# 아이디 : admin, 비번 : admin, 이메일 : admin@kh.co.kr, 권한이 : ADMIN
INSERT INTO MEMBER(ME_ID, ME_PW, ME_EMAIL, ME_AUTHORITY, ME_MS_STATE)
VALUES('admin', 'admin', 'admin@kh.co.kr', 'admin', '이용중');

# 관리자가 커뮤니티를 등록(공지, 자유, 토론, 공부)
INSERT INTO COMMUNITY(CO_NAME) VALUES('공지');
INSERT INTO COMMUNITY(CO_NAME) VALUES('자유');
INSERT INTO COMMUNITY(CO_NAME) VALUES('토론');
INSERT INTO COMMUNITY(CO_NAME) VALUES('공부');

# abc123회원이 자유 커뮤니티에 게시글을 등록했을 때 실행된느 쿼리
# 제목 : 테스트, 내용 : 테스트입니다. 첨부파일 : 없음
INSERT INTO BOARD(BO_CO_NUM, BO_ME_ID, BO_TITLE, BO_CONTENT)
VALUES(2, 'abc123', '테스트', '테스트입니다.');

INSERT INTO BOARD(BO_CO_NUM, BO_ME_ID, BO_TITLE, BO_CONTENT)
SELECT CO_NUM, 'abc123', '테스트', '테스트입니다.' FROM COMMUNITY WHERE CO_NAME = '자유';

# ADMIN 관리자가 공지 커뮤니티에 게시글을 등록했을 때 실행되는 쿼리
# 제목 : 공지사항, 내용 : 공지사항입니다., 첨부파일 : 공지사항1.JPG
# 첨부파일은 서버업로드 되면 현재 날짜를 기준으로 폴더를 생성해서 업로드 함
# 업로드된 첨부파일은 /2024/02/14/파일명으로 저장
INSERT INTO BOARD(BO_CO_NUM, BO_ME_ID, BO_TITLE, BO_CONTENT)
VALUES(1, 'ADMIN', '공지사항', '공지사항입니다.');

INSERT INTO FILE(FI_BO_NUM, FI_NAME, FI_ORI_NAME)
VALUES(3, '/2024/02/14/공지사항1.jpg', '공지사항1.jpg');