<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../layout/header.jsp" />
<body>
	<div align="center">
		<div>
			<h1>로 그 인</h1>
		</div>
		<div>
			<form id="frm" action="login.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="100">아이디</th>
							<td width="200"><input type="text" id="memberId"
								name="memberId"></td>
						</tr>
						<tr>
							<th width="100">패스워드</th>
							<td width="200"><input type="password" id="memberPassword"
								name="memberPassword"></td>
						</tr>
					</table>
				</div>
				<br>
				<div>
					<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp; 
					<input type="reset" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>