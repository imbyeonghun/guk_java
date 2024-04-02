<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="<c:url value="/login"/>" method="post">
		<div class="form-group">
			<label for="id">id:</label>
			<input type="text" class="form-control" id="id" placeholder="Enter id" name="me_id">
		</div>
		<div class="form-group">
			<label for="pw">pw:</label>
			<input type="password" class="form-control" id="pw" placeholder="Enter pw" name="me_pw">
		</div>
	</form>
</body>
</html>