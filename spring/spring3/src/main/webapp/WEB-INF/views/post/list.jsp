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
	<form action="<c:url value="/post/list"/>" id="searchForm">
		<div class="input-group mb-3">
			<select name="type" class="form-control">
				<option value="all" <c:if test="${pm.cri.type == 'all'}">selected</c:if>>전체</option>
				<option value="title" <c:if test="${pm.cri.type == 'title'}">selected</c:if>>제목</option>
				<option value="writer" <c:if test="${pm.cri.type == 'writer'}">selected</c:if>>작성자</option>
			</select>
			<input type="text" class="form-control" placeholder="Search" name="search" value="${pm.cri.search}">
			<button class="btn btn-outline-success">검색</button>
		</div>
		<select class="form-control col-4 offset-8 mb-4" name="order">
			<option value="bo_num" <c:if test="${pm.cri.order == 'bo_num'}">selected</c:if>>최신순</option>
			<option value="bo_view" <c:if test="${pm.cri.order == 'bo_view'}">selected</c:if>>조회수순</option>
		</select>
	</form>
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
					<td>${pm.totalCount - vs.index - pm.cri.pageStart}</td>
					<td>
						<a>${post.bo_title}</a>
					</td>
					<td>${post.bo_me_id}</td>
					<td>${post.bo_view}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="<c:url value="/post/insert"/>" class="btn btn-outline-success">글 쓰기</a>
	<div>
		<ul class="pagination justify-content-center">
			<c:if test="${pm.prev}">
				<c:url value="/post/list" var="url">
					<c:param name="page" value="${pm.startPage-1}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
					<c:param name="order" value="${pm.cri.order}"/>
				</c:url>
				<li class="page-item">
					<a class="page-link" href="${url}">이전</a>
				</li>
			</c:if>
			<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
				<c:url value="/post/list" var="url">
					<c:param name="page" value="${i}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
					<c:param name="order" value="${pm.cri.order}"/>
				</c:url>
				<c:set var="active" value="${pm.cri.page == i ? 'active' : ''}"/>
				<li class="page-item ${active}">
					<a class="page-link" href="${url}">${i}</a>
				</li>
			</c:forEach>
			<c:if test="${pm.next}">
				<c:url value="/post/list" var="url">
					<c:param name="page" value="${pm.endPage+1}"/>
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
					<c:param name="order" value="${pm.cri.order}"/>
				</c:url>
				<li class="page-item">
					<a class="page-link" href="${url}">다음</a>
				</li>
			</c:if>
		</ul>
	</div>
	<script type="text/javascript">
		$("[name=order]").change(function(){
			$("#searchForm").submit();	// 이벤트 실행
		});
	</script>
</body>
</html>