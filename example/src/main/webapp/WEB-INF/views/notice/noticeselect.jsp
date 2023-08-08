<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${n.noticeId } : ${n.noticeWriter } : ${n.noticeTitle }
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
						<th width="400">첨부파일주소</th>
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
						<td>${n.noticeAttechDir }</td>
						<td align="center">${n.noticeHit }</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>