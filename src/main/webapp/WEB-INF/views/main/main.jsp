<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
	.newest_list > li{
		float: left;
		width: 100%;
		height: 200px;
	} 
	
	.newest_container {
		width:100%;
	}
	
	@media (min-width: 856px){
		.newest_list > li{
			float: left;
			width: 33%;
			height: 200px;
		}
	}
</style>
		
		<!-- Section One -->
			<div class="wrapper style2">
				<section class="container">
					<div class="row double">
						<div class="6u">
							<header class="major">
								<h2>스마트폰 구글 플레이에서 확인하세요!</h2>
								<span class="byline">안드로이드 구글 플레이에서 '대한민국 골목'구석구석을 검색하셔서 설치 하세요!</span>
							</header>
						</div>
						<div class="6u">
							<h3>여러분의 가게를 홍보하세요</h3>
							<p>자영업을 하시는 분 이라면 누구나 회원 가입하셔서 회원님의 가게를 홍보 하세요!</p>
							<c:choose>
								<c:when test="${login.email ne null}">
									<a href="/board/regist" class="button">상가등록하러 가기</a>		
								</c:when>
								
								<c:when test="${login.email eq null}">
									<a href="/main/signup" class="button">회원 가입하러 가기</a>	
								</c:when>
							</c:choose>
						</div>
					</div>
				</section>
			</div>

		
		<!-- Section Three -->
			<div class="wrapper style4">
				<section class="container">
					<header class="major">
						<h2>이달의 최신 골목 정보</h2>
						<span class="byline">여러분의 가게에 대박을 기원 합니다.</span>
					</header>
					<div class="row flush">
						<div class="4u newest_container">
							<ul class="special-icons newest_list">
								<c:forEach var="newest" items="${newestList}">
									<li>
										<span class="fa fa-cogs"></span>
										<h3><a href="/board/view?&page=${newest.seq}">${newest.store_id}</a></h3>
										<p>${newest.event_comment}</p>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</section>
			</div>
		
		<!-- Team -->
			<div class="wrapper style5">
				<section id="team" class="container">
					<header class="major">
						<h2>이달의 Best 방문객 정보</h2>
						<span class="byline">앱을 통해서 여러분에게 드리는 응원의 메시지 입니다!</span>
					</header>
					<div class="row">
						<c:forEach var="rank" items="${rankList}">
							<div class="3u">
								<a href="/board/view?page=${rank.sanga_seq}" class="image">
									<c:choose>
										<c:when test="${rank.atchmnfl_mask_nm ne null}">
										<!-- 운영경로 -->
										<img style="border: none; border-radius: 0; border-color: none; width: 162px; height: 162px;" src="/fileupload/${rank.atchmnfl_mask_nm}" alt="">
										<!-- 개발경로 -->
<%-- 									<img style="border: none; border-radius: 0; border-color: none; width: 162px; height: 162px;" src="/upload/images/${rank.atchmnfl_mask_nm}" alt=""> --%>	
										</c:when>
										
										<c:when test="${rank.atchmnfl_mask_nm eq null}">
											<img style="border: none; border-radius: 0; border-color: none;" src="/images/placeholder.png" alt="">
										</c:when>
									</c:choose>
								</a>
								<a style="color: white; text-decoration: none;" href="/board/view?page=${rank.sanga_seq}">
									<h3>${rank.store_id}</h3>
									<p>${rank.rank_comment}</p>
									<p>평점: ${rank.rank}</p>
								</a>
							</div>
						</c:forEach>
					</div>
				</section>
			</div>


<!-- <!DOCTYPE html>. -->

<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="EUC-KR"> -->
<!-- <title>메인페이지</title> -->
<!-- </head> -->
<!-- <body> -->
<%-- 	<p>user : ${login.email}</p> --%>
<%-- 	<p>user : ${login}</p> --%>
<%-- 	<p>user : ${login.pw}</p> --%>
	
<%-- 	<c:choose> --%>
<%-- 	    <c:when test="${login.email ne null}"> --%>
<!-- 	        <p>로그아웃 <a href="/main/logoutproc">하기</a></p> -->
<%-- 	    </c:when> --%>
	 
<%-- 	    <c:when test="${login.email eq null}"> --%>
<!-- 	       	<p>로그인 <a href="/main/login">이동하기</a></p> -->
<%-- 	    </c:when> --%>
<%-- 	</c:choose> --%>
<!-- 	<p>회원가입 <a href="/main/signup">이동하기</a></p> -->
<!-- 	<p>상가등록하기 <a href="/board/regist">이동하기</a></p> -->
<!-- 	<p>상가리스트보러가기 <a href="/board/list">이동하기</a></p> -->
<!-- </body> -->
<!-- </html> -->