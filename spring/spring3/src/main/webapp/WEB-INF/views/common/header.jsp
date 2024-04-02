<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<a class="navbar-brand" href="#">
		<img alt="logo" src="<c:url value="/resources/img/bird.jpg"/>" style="width: 40px;"/>
	</a>
	
	<ul class="navbar-nav">
		<li class="nav-item">
			<a class="nav-link" href="<c:url value="/signup"/>">회원가입</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="<c:url value="/login"/>">로그인</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="#">Link 3</a>
		</li>
	</ul>
</nav>