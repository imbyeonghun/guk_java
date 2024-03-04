<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"/>
	<div class="container">
		<form action="<c:url value="/board/update"/>" method="post">
			<h1>게시글 수정</h1>
			<input type="hidden" name="num" value="${board.bo_num}">
			<div class="mb-3 mt-3">
				<label for="community" class="form-label">게시판</label>
				<select class="form-control" name="community" id="community">
					<c:forEach items = "${list}" var = "community">
						<option value="${community.co_num}" <c:if test="${board.bo_co_num == community.co_num}">selected</c:if>>${community.co_name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3 mt-3">
				<label for="title">제목</label>
				<input type="text" class="form-control" id="title" name="title" value="${board.bo_title}">
			</div>
			<div class="mb-3 mt-3">
				<label for="content">내용</label>
				<textarea rows="5" class="form-control" id="content" name="content">${board.bo_content}</textarea>
			</div>
			<button type="submit" class="btn btn-outline-success col-12">수정</button>
		</form>
	</div>
</body>
</html>