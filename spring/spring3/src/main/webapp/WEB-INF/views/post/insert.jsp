<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 리스트</title>
</head>
<body>
<div class="container">
	<form action="<c:url value="/post/insert"/>" method="post" enctype="multipart/form-data">
		<h1>게시글 등록</h1>
		<div class="form-group">
			<select name="bo_co_num" class="form-control">
				<c:forEach items="${community}" var="cm">
					<option value="${cm.co_num}">${cm.co_name}</option>	
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" class="form-control" name="bo_title" id="title">
		</div>
		<div>
			<label for="content">내용</label>
			<textarea name="bo_content" class="form-control" id="content" required rows="10"></textarea>
		</div>
		<div class="form-group">
			<label>파일</label>
			<input type="file" class="form-control" name="file"/>
			<input type="file" class="form-control" name="file"/>
			<input type="file" class="form-control" name="file"/>
		</div>
		<button class="btn btn-outline-success">등록</button>
	</form>
</div>
</body>
</html>