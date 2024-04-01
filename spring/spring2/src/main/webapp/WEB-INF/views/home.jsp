<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<P>  The time on the server is ${serverTime}. </P>
	<!-- 
	서버로 ID를 입력해서 전송하도록 코드를 작성
	테스트 결과 
	- STS 콘솔창에 화면에서 보낸 ID가 출력
	1. 화면 추가(링크추가)
		- 보낸 url을 선정 : /id
		- 보낼 방식 : get
		- 보낼 데이터의 변수명 : id
	2. 컨트롤러에 메서드
		- url을 처리하는 메서드가 없으면 추가 있으면 수정
		- 작업 -> 작업이 끝난 후 보낼 화면이나 url을 설정
	-->
	<h1>${text}</h1>
	<form action="<c:url value="/id"/>" method="get">
		<label for="id">아이디</label>
		<input type="text" name="id" id="id">
		<button type="submit">전송</button>
	</form>
	<!-- 
	a태그를 이용하여 서버에 이름을 전송해서 STS콘솔창에 출력하는 코드 작성
	1. 링크 추가
		- url : /name
		- 전송할 변수명 : name
		- 전송할 이름 : 홍길동
	2. 컨트롤러에 메서드
	-->
	<a href="<c:url value="/name?name=홍길동"/>">홍길동</a><br><br>
	<!-- 
	LoginDTO클래스를 이용하여 화면에서 id,pw를 서버로 전송하고, 
	서버에서는 화면에서 보낸 id,pw를 콘솔창에 출력하는 코드
	1. LoginDTO 추가
	2. 링크 추가
		- url : /login
	3. 컨트롤러 메서드
		- 콘솔창에 id,pw이 담긴 loginDTO객체 출력한 후 메인 페이지로 text.jsp
	-->
	<form action="<c:url value="/login"/>" method="post">
		<label for="id">아이디</label>
		<input type="text" name="id" id="id">
		<br>
		<label for="pw">비밀번호</label>
		<input type="password" name="pw" id="pw">
		<button type="submit">전송</button>
	</form>
	<a href="<c:url value="/send/object"/>">객체 여러개를 서버에 전송하기</a>
	<br>
	<a href="<c:url value="/send/path/123"/>">경로에 데이터를 추가해서 전송하기</a>
	<br>
	<a href="<c:url value="/ajax"/>"> ajax예제</a>
</body>
</html>
