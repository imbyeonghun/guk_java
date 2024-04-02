<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="<c:url value="/signup"/>" method="post">
		<div class="form-group">
			<label for="id">id:</label>
			<input type="text" class="form-control" id="id" placeholder="Enter id" name="me_id">
		</div>
		<div class="form-group">
			<label for="pw">pw:</label>
			<input type="password" class="form-control" id="pw" placeholder="Enter pw" name="me_pw">
		</div>
		<div class="form-group">
			<label for="email">email:</label>
			<input type="email" class="form-control" id="email" placeholder="Enter email" name="me_email">
		</div>
		<div class="form-group form-check">
			<label class="form-check-label">
				<input class="form-check-input" type="checkbox" name="remember"> Remember me
			</label>
		</div>
		<button type="submit" class="btn btn-primary">회원가입</button>
	</form>
</body>
</html>