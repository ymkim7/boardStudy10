<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/resources/css/board.css" rel="stylesheet" type="text/css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>조회 페이지</h1>
	
	<form id="modifyForm" action="/board/modify" method="post">
		<div class="input_wrap">
			<label>게시판 번호</label>
			<input name="bno" readonly="readonly" value='<c:out value="${pageInfo.bno}"/>' >
		</div>
		
		<div class="input_wrap">
			<label>게시판 제목</label>
			<input name="title" value='<c:out value="${pageInfo.title}"/>' >
		</div>
		
		<div class="input_wrap">
			<label>게시판 내용</label>
			<textarea rows="3" name="content"><c:out value="${pageInfo.content}"/></textarea>
		</div>
		
		<div class="input_wrap">
			<label>게시판 작성자</label>
			<input name="writer" readonly="readonly" value='<c:out value="${pageInfo.writer}"/>' >
		</div>
		
		<div class="input_wrap">
			<label>게시판 등록일</label>
			<input name="regdater" readonly="readonly" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${pageInfo.regdate}"/>' >
		</div>
		
		<div class="input_wrap">
			<label>게시판 수정일</label>
			<input name="updateDate" readonly="readonly" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${pageInfo.updateDate}"/>' >
		</div>
		
		<div class="btn_wrap">
			<a class="btn" id="list_btn">목록 페이지</a> 
			<a class="btn" id="modify_btn">수정 완료</a>
			<a class="btn" id="cancel_btn">수정 취소</a>
		</div>
	</form>
	
	<form id="infoForm" action="/board/modify" method="get">
		<input type="hidden" id="bno" name="bno" value='<c:out value="${pageInfo.bno}"/>'>
		<input type="hidden" id="pageNum" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
		<input type="hidden" id="amount" name="amount" value='<c:out value="${cri.amount}"/>'>
		<input type="hidden" id="keyword" name="keyword" value="${cri.keyword }">
		<input type="hidden" id="type" name="type" value="${cri.type }">
	</form>
</body>

<script type="text/javascript">
	$(document).ready(function(){
		var form = $("#infoForm");
		var mForm = $("#modifyForm");
		
		$("#list_btn").on("click", function(){
			form.find("#bno").remove();
			form.attr("action", "/board/list");
			form.submit();
		});
		
		$("#modify_btn").on("click", function(){
			mForm.submit();
		});
		
		$("#cancel_btn").on("click", function(){
			form.attr("action", "/board/get");
			form.submit();
		});
	});
</script>
</html>