<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>회원 목록 보기</h1></div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th width="100">아이디</th>
					<th width="100">이름</th>
					<th width="150">전화번호</th>
					<th width="200">주소</th>
					<th width="100">가입일자</th>
					<th width="100">탈퇴일자</th>
					<th width="100">권한</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${members }" var="m">
					<tr>
						<td align="center">${m.memberId }</td>
						<td align="center">${m.memberName }</td>
						<td align="center">${m.memberTel }</td>
						<td>${m.memberAddress }</td>
						<td align="center">${m.memberEdate }</td>
						<td align="center">${m.memberSdate }</td>
						<td align="center">${m.memberAuthor }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>