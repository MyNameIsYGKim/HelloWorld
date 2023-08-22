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
			<h1>글 작 성</h1>
		</div>
		<div>
			<form id="frm" action="noticeinsert.do" method="post" enctype="multipart/form-data">
				<div>
					<table border="1">
						<tr>
							<th width="100">작성자</th>
							<td>
								<input type="text" id="noticeWriter" name="noticeWriter" value="${name}" readonly="readonly">
							</td>
							<th width="100">작성일자</th>
							<td>
								<input type="date" id="noticeDate" name="noticeDate" required="required">
							</td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="3">
								<input type="text" size="84" id="noticeTitle" name="noticeTitle">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3">
							<textarea rows="20" cols="80" id="noticeSubject" name="noticeSubject">
							</textarea>
							</td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td colspan="3">
								<input type="file" id="file" name="file">
							</td>
						</tr>
					</table>
				</div>
				<br>
				<div></div>
				<div>
					<input type="submit" value="작성">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>