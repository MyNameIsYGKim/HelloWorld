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
	<div><h1>회원 목록</h1></div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th width="100">아이디</th>
					<th width="100">이름</th>
					<th width="100">나이</th>
					<th width="100">성별</th>
					<th width="200">전화번호</th>
					<th width="300">주소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${members }" var="m">
				<tr>
					<td align="center">${m.memberId }</td>
					<td align="center">${m.memberName }</td>
					<td align="center">${m.memberAge }</td>
					<td align="center">${m.memberGender }</td>
					<td align="center">${m.memberTell }</td>
					<td>${m.memberAddress }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>