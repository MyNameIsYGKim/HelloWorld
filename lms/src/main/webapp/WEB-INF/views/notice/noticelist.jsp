<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fnt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../layout/header.jsp" />
<div align="center">
	<div><h1>게시글 목록</h1></div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th width="50">번호</th>
					<th width="100">작성자</th>
					<th width="200">제목</th>
					<th width="500">내용</th>
					<th width="150">날짜</th>
					<th width="50">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${notices }" var="n">
				<tr>
					<td align="center">${n.boardId }</td>
					<td align="center">${n.boardWriter }</td>
					<td>${n.boardTitle }</td>
					<td>${n.boardSubject }</td>
					<td align="center">${n.boardDate }</td>
					<td align="center">${n.boardHit }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>