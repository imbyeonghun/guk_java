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
	<h1>게시글 리스트</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${postList}" var="post" varStatus="vs">
				<tr>
					<td>${postList.size() - vs.index}</td>
					<td>
						<a>${post.bo_title}</a>
					</td>
					<td>${post.bo_me_id}</td>
					<td>${post.bo_view}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>