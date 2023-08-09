<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시글 수정</h1>
		</div>
		<div>
			<form id="frm" action="noticeedit.do" method="post"
				enctype="multipart/form-data">
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
									<th width="200">첨부파일</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td align="center">
										<input type="text" id="noticeId" name="noticeId" 
											value="${n.noticeId }" readonly="readonly">
									</td>
									<td align="center">
										<input type="text" id="noticeWriter" name="noticeWriter" 
											value="${n.noticeWriter }" readonly="readonly">
									</td>
									<td>
										<input type="text" id="noticeTitle" name="noticeTitle" 
											value="${n.noticeTitle }">
									</td>
									<td>
										<textarea rows="20" id="noticeSubject" name="noticeSubject">${n.noticeSubject }</textarea>
									</td>
									<td align="center">
										<input type="date" id="noticeDate" name="noticeDate" 
											value="${n.noticeTitle }">
									</td>
									<td>${n.noticeAttech }</td>
									<td><input type="file" id="file" name="file"></td>
								</tr>
							</tbody>
						</table>
					</div><br>
					<div>
						<input type="submit" onclick=" location.href='noticeedit.do'"value="수정">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="취소">
					</div>
					<input type="hidden" id="noticeId" name="noticeId" value="${n.noticeId }">
				</div>
			</form>
		</div>
	</div>
</body>
</html>