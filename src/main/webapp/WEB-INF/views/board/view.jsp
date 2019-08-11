<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상가페이지</title>
</head>
<body>
	<div class="card">
	  <p class="card-text"></p>
	  <h5 class="card-header">${sangaView.seq}. 상가명: ${sangaView.store_id}</h5>
	  <div class="card-body">
	    <h5 class="card-title">${sangaView.email}</h5>
	    <p class="card-text">${sangaView.event_comment}</p>
	    <p class="card-text">${sangaView.reg_dt}</p>
	    <p class="card-text">${sangaView.mod_dt}</p>
	    <c:choose>
		    <c:when test="${login.email eq sangaView.email}">
        	    <p class="card-text"><a href="/board/regist?seq=${sangaView.seq}">수정</a></p>
	    		<p class="card-text"><a href="/board/deleteproc?seq=${sangaView.seq}&file=${sangaImageView.get(0).file_id}">삭제</a></p>
		    </c:when>
		</c:choose>
		<ul>
			<c:forEach var="item" items="${sangaImageView}">
				<li><img src="/upload/images/${item.atchmnfl_mask_nm}" style="width:50%; height:450px;"></li>
			</c:forEach>
		</ul>
		
		
	  </div>
	</div>
	<p><a href="/board/list">리스트로</a></p>
</body>
</html>