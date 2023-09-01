<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Cards</title>

<!-- Custom fonts for this template-->
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
	

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">

<link href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script src="//cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
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
				<input type="hidden" id="noticeId" name="noticeId"
					value="${n.noticeId }">
			</form>
		</div>
	</div>

	<br>
	<form id="frm321" method="post">
		댓글내용
		<input type="text" id="replyBox" name="replyBox">
		작성자
		<input type="text" id="replyerBox" name="replyerBox">
		<button id="addRow">등록</button>
	</form>
	<!-- 댓글부분. -->
	<h3>댓글 목록</h3>
	<table id="example" class="display" style="width: 100%">
		<thead>
			<tr>
				<th>댓글번호</th>
				<th>댓글내용</th>
				<th>작성자</th>
				<th>작성일자</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>댓글번호</th>
				<th>댓글내용</th>
				<th>작성자</th>
				<th>작성일자</th>
			</tr>
		</tfoot>
	</table>
	<!-- end of 댓글 -->

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
	<script src="./js/reply.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	
	<script>
		
		// 댓글등록.
		$('#addRow').on('click', function () {
			let content = $('#replyBox').val();
			let writer = $('#replyerBox').val();
			const reply = new Reply();
			const param = {
					noticeId,
					reply: content,
					replyer: writer
			}
			console.log(param);
			reply.replyAdd(param, function (data) {
				addNewRow(data.data);
			})
		})
		
		function addNewRow(row) {
			table.row
				.add({
					replyId: row.replyId,
			    	reply: row.reply,
			    	replyer: row.replyer,
			    	replyDate: row.replyDate
				})
		        .draw(false);
		}
		
		var noticeId = '<c:out value="${n.noticeId}" />';
		console.log('notice: ', noticeId);
		
		const table = new DataTable('#example', {
		    ajax: 'jquery/AjaxDatatable.do',
		    columns: [
		    	{ data: 'replyId'},
		    	{ data: 'reply'},
		    	{ data: 'replyer'},
		    	{ data: 'replyDate'}
		    ]
		});
	</script>

	<script type="text/javascript">
		function noticeUpdate(str){
			if(str == 'E'){
				console.log(${n.noticeId});
				document.getElementById("frm").action="noticeeditform.do";
			}else{
				document.getElementById("frm").action="noticedelete.do";
			}
			document.getElementById("frm").submit();
		}
	</script>

</body>
</html>