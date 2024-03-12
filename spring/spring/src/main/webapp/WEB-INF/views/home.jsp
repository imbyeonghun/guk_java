<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p> 안녕하세요. 제 이름은${name}입니다.</p>
<form action="<c:url value="/"/>" method="post">
	<input type="text" name="name" placeholder="이름">
	<br>
	<input type="number" name="age" placeholder="나이">
	<br>
	<button type="submit">전송</button>
</form>
<!-- url경로에 데이터를 추가하여 서버에 전송 -->
<a href="<c:url value="/test/123"/>">링크 테스트</a>
</body>
</html>