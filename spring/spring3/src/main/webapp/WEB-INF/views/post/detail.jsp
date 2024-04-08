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
<div class="container">
	<h1>게시글 상세</h1>
	<div>
 		<label>게시판</label>
 		<div class="form-control">${board.bo_co_num}</div>
 	</div>
	<div>
 		<label>제목</label>
 		<div class="form-control">${board.bo_title}</div>
 	</div>
 	<div>
 		<label>작성자</label>
 		<div class="form-control">${board.bo_me_id}</div>
 	</div>
 	<div>
 		<label>조회수</label>
 		<div class="form-control">${board.bo_view}</div>
 	</div>
 	<div>
 		<label>내용</label>
 		<div class="form-control" style="min-height: 400px">${board.bo_content}</div>
 	</div>
	<div class="form-group">
		<c:forEach items="${file}" var="list">
			<c:if test="${list.img}">
				<a href="<c:url value="/download${list.fi_name}"/>" download="${list.fi_ori_name}">
					<img alt="이미지" height="100" src="<c:url value="/download${list.fi_name}"/>">
				</a>
			</c:if>
			<c:if test="${!list.img}">
				<a href="<c:url value="/download${list.fi_name}"/>" download="${list.fi_ori_name}">${list.fi_ori_name}</a>
			</c:if>
		</c:forEach>
		
	</div>
	<a href="<c:url value="/post/list"/>" class="btn btn-outline-success">목록으로</a>
</div>
</body>
</html>