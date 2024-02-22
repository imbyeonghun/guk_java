<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int num = 10;
	%>
	<h1>메인 페이지입니다.</h1>
	<!-- get 방식 -->
	<a href="<%=request.getContextPath() %>?data=안녕하세요">데이터 전송</a>
	<!-- form태그에서 mothod를 지정하지 않으면 get 방식 -->
	<form action="<%=request.getContextPath() %>">
		<h2>form태그 get방식 전송</h2>
		<input type="text" name="id">
		<button>전송</button>
	</form>
	<h1><%=num %></h1>
	<h1><%=request.getContextPath() %></h1>
	
	<!-- /login을 처리하는 서블릿을 추가한 후 login.jsp와 연결하는 작업 -->
	<a href="<%=request.getContextPath()%>/login">로그인으로</a>
	<br>
	<!-- /signup을 처리하는 서블릿을 추가한 후 signup.jsp와 연결하는 작업 -->
	<a href="<%=request.getContextPath()%>/signup">회원가입으로</a>
	
	<h1>서버에서 보낸 나이 : ${age}</h1>
	<script type="text/javascript">
		let age = 20;
		let str = `나이 : \${age}`;
		console.log(str);
	</script>
</body>
</html>