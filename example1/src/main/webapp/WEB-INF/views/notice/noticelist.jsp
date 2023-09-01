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
					<select id="key" name="key">
						<option value="title">제목</option>
						<option value="subject">내용</option>
						<option value="writer">작성자</option>
					</select>
					<input type="text" id="val" name="val">
					<input type="button" onclick="searchList()" value="검색">
			</form>
				<div>
					<table border="1">
						<thead>
							<tr>
								<th width="50">번호</th>
								<th width="100">작성자</th>
								<th width="200">제목</th>
								<th width="100">날짜</th>
								<th width="200">첨부파일</th>
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
			
		</div>
		<div>
			<form id="noticefrm" action="noticeselect2.do" method="post">
				<input type="hidden" id="noticeId" name="noticeId">
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function selectNotice(n) {
			document.getElementById("noticeId").value = n;
			document.getElementById("noticefrm").submit();
		}
		
		function searchList(){
			// ajax를 이용해서 검색결과를 가져오고 화면을 재구성한다.
			let key = document.getElementById("key").value;
			let val = document.getElementById("val").value;
			let payload = "key="+key+"&val="+val;
			let url = "ajaxnoticesearch.do";
			
			fetch(url, {
				method: "POST",
				headers:{
					"Content-Type": "application/x-www-form-urlencoded",
				},
				body: payload
			})	.then(response => response.json())
				.then(json => htmlConvert(json));
		}
		
		function htmlConvert(datas){
			document.querySelector('tbody').remove();
			const tbody = document.createElement('tbody');
			
			// tbody에 data추가
			tbody.innerHTML = datas.map(data => htmlView(data)).join('');
			
			// table에 tbody추가
			document.querySelector('table').appendChild(tbody);
		}
		
		function htmlView(data){
			return `
					<tr onmouseover="this.style.background='#F7FE2E'"
						onmouseout="this.style.background='#FFFFFF'"
						onclick="selectNotice(\${data.noticeId })">
			
						<td align="center">\${data.noticeId }</td>
						<td align="center">\${data.noticeWriter }</td>
						<td>\${data.noticeTitle }</td>
						<td align="center">\${data.noticeDate }</td>
						<td>\${data.noticeAttech }</td>
						<td align="center">\${data.noticeHit }</td>
					</tr>
			`
		}
	</script>
</body>
</html>