<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		
		<!-- Section Three -->
			<c:choose>
		        <c:when test="${updataValues.seq ne null}">
		            <form action="/board/updateproc" method="post" enctype="multipart/form-data">
		                <input type="hidden" id="page" name="page" value="${updataValues.seq}">
		                <input type="hidden" id="file" name="file" value="${updataValues.file_id}">
		        </c:when>
		        <c:when test="${updataValues.seq eq null}">
		            <form action="/board/registproc" method="post" enctype="multipart/form-data">
		        </c:when>
		    </c:choose>
			<div class="wrapper style4">
				<section class="container">
					<div class="row flush">
						<div class="8u">
							<ul class="special-icons">
								<li>
									<h3>관광지 선택</h3>
									<input type="text" style="width:100%">
								</li>
								<li>
									<h3>상가명 입력</h3>
									<input id="store_id" name="store_id" type="text" value="${updataValues.store_id}">
								</li>
								<li>
									<h3>홍보글 입력</h3>
									<textarea id="event_comment" name="event_comment" rows="5" cols="5">${updataValues.event_comment}</textarea>
								</li>
								<li>
									<input multiple="multiple" id="imgFiled" name="imgFiled" type="file">
									
								</li>
								<li>
									<input class="button" type="submit" value="버튼을 눌러 완료하세요" />
								
<!-- 									<a href="#" class="button">버튼을 눌러 완료 하세요</a> -->
								</li>
							</ul>
						</div>
						
						
					</div>
				</section>
			</div>
			</form>
		
		<!-- Team 
			<div class="wrapper style5">
				<section id="team" class="container">
					<header class="major">
						<h2>이달의 Best 방문객 정보</h2>
						<span class="byline">앱을 통해서 여러분에게 드리는 응원의 메시지 입니다!</span>
					</header>
					<div class="row">
						<div class="3u">
							<a href="#" class="image"><img src="images/placeholder.png" alt=""></a>
							<h3>중앙시장 비비드</h3>
							<p>여친이랑 가서 커플링 하나 했어요..번창하세요</p>
						</div>
						<div class="3u">
							<a href="#" class="image"><img src="images/placeholder.png" alt=""></a>
							<h3>중앙시장 칼국수</h3>
							<p>숨은 맛집이 여기 있었네요...</p>
						</div>
						<div class="3u">
							<a href="#" class="image"><img src="images/placeholder.png" alt=""></a>
							<h3>떡볶이</h3>
							<p>완전 매움 ㅠㅠ</p>
						</div>
						<div class="3u">
							<a href="#" class="image"><img src="images/placeholder.png" alt=""></a>
							<h3>VR 체험장</h3>
							<p>아이들이 너무 좋아하네요. 또 올께요</p>
						</div>
					</div>
				</section>
			</div>
-->

<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="EUC-KR"> -->
<!-- <title>상가등록</title> -->
<!-- </head> -->
<!-- <body> -->
<%-- 	<c:choose> --%>
<%-- 	    <c:when test="${updataValues.seq ne null}"> --%>
<!-- 	        <form action="/board/updateproc" method="post" enctype="multipart/form-data"> -->
<%-- 	        <input type="hidden" id="page" name="page" value="${updataValues.seq}"> --%>
<%-- 	        <input type="hidden" id="file" name="file" value="${updataValues.file_id}"> --%>
<%-- 	    </c:when> --%>
	 
<%-- 	    <c:when test="${updataValues.seq eq null}"> --%>
<!-- 	       	<form action="/board/registproc" method="post" enctype="multipart/form-data"> -->
<%-- 	    </c:when> --%>
<%-- 	</c:choose> --%>

<%-- 		<input type="hidden" id="email" name="email" value="${login.email}" > --%>
<!-- 		관광지선택<input id="location" name="location" type="text"> -->
<%-- 		도<input id="store_addr1" name="store_addr1" type="text" value="${updataValues.store_addr1}"> --%>
<%-- 		시/군/구<input id="store_addr2" name="store_addr2" type="text" value="${updataValues.store_addr2}"> --%>
<%-- 		관광지<input id="store_addr3" name="store_addr3" type="text" value="${updataValues.store_addr3}"> --%>
<%-- 		상가명입력<input id="store_id" name="store_id" type="text" value="${updataValues.store_id}"> --%>
<%-- 		홍보글입력<textarea id="event_comment" name="event_comment" rows="5" cols="5">${updataValues.event_comment}</textarea> --%>
<!-- 		이미지업로드<input multiple="multiple" id="imgFiled" name="imgFiled" type="file"> -->

<!-- 		<input type="submit"> -->
<!-- 	</form> -->
<!-- 	<p><a href="/board/list">되돌아가기</a></p> -->
<!-- </body> -->
<!-- </html> -->