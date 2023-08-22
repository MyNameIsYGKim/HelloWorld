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
			<h1>게시글 조회</h1>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th width="50">번호</th>
						<th width="100">작성자</th>
						<th width="200">제목</th>
						<th width="400">내용</th>
						<th width="100">날짜</th>
						<th width="200">첨부파일명</th>
						<th width="50">조회수</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td align="center">${n.noticeId }</td>
						<td align="center">${n.noticeWriter }</td>
						<td>${n.noticeTitle }</td>
						<td>${n.noticeSubject }</td>
						<td align="center">${n.noticeDate }</td>
						<td>${n.noticeAttech }</td>
						<td align="center">${n.noticeHit }</td>
					</tr>
				</tbody>
			</table>
		</div>
		<br>
			<div>
			<c:if test="${name eq n.noticeWriter }">
				<button type="button" onclick="noticeUpdate('E')">수정</button>&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="noticeUpdate('D')">삭제</button>&nbsp;&nbsp;&nbsp;
			</c:if>
				<button type="button" onclick="location.href='noticelist.do'">목록</button>
			</div>
		<div>
			<form id="frm" method="post">
				<input type="hidden" id="noticeId" name="noticeId" value="${n.noticeId }">
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function noticeUpdate(str){
			if(str == 'E'){
				document.getElementById("frm").action="noticeeditform.do";
			}else{
				document.getElementById("frm").action="noticedelete.do";
			}
			document.getElementById("frm").submit();
		}
	</script>
</body>
</html>