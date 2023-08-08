<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시글 목록 보기</h1>
		</div>
		<div>
			<form id="frm" method="post">
				<input type="button" onclick="selectNotice()" value="검색">
				<div>
					<table border="1">
						<thead>
							<tr>
								<th width="50">번호</th>
								<th width="100">작성자</th>
								<th width="200">제목</th>
								<th width="100">날짜</th>
								<th width="200">첨부파일명</th>
								<th width="50">조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${not empty notices }">
								<c:forEach items="${notices }" var="n">
									<tr onmouseover="this.style.background='#F7FE2E'"
										onmouseout="this.style.background='#FFFFFF'"
										onclick="selectNotice(${n.noticeId })">
										<td align="center">${n.noticeId }</td>
										<td align="center">${n.noticeWriter }</td>
										<td>${n.noticeTitle }</td>
										<td align="center">${n.noticeDate }</td>
										<td>${n.noticeAttech }</td>
										<td align="center">${n.noticeHit }</td>
									</tr>
								</c:forEach>
							</c:if>
							<c:if test="${empty notices }">
								<tr>
									<td colspan="6" align="center">빈 목록입니다.</td>
								</tr>
							</c:if>
						</tbody>
					</table>
				</div>
				<br>
				<div>
					<c:if test="${not empty id }">
						<button type="button" onclick="location.href='noticeform.do'">글쓰기</button>
					</c:if>
				</div>
			</form>
		</div>
		<div>
			<form id="noticefrm" action="noticeselect.do" method="get">
				<input type="hidden" id="noticeId" name="noticeId">
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function selectNotice(n) {
			document.getElementById("noticeId").value = n;
			document.getElementById("noticefrm").submit();
		}
	</script>


</body>
</html>