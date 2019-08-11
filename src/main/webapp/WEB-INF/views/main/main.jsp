<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
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
						<h2>이달의 Best 골목 정보</h2>
						<span class="byline">여러분의 가게에 대박을 기원 합니다.</span>
					</header>
					<div class="row flush">
						<div class="4u">
							<ul class="special-icons">
								<li>
									<span class="fa fa-cogs"></span>
									<h3>URP 커피숍</h3>
									<p>여행이 지처갈때 조용히 아메리카노 한잔 하고 가세요.</p>
								</li>
								<li>
									<span class="fa fa-wrench"></span>
									<h3>VR 체험장</h3>
									<p>지금오시면 20분 연장 해드립니다.</p>
								</li>
								<li>
									<span class="fa fa-leaf"></span>
									<h3>원조 칼국수집</h3>
									<p>중앙시장 골목에 있어요.</p>
								</li>
							</ul>
						</div>
						<div class="4u">
							<ul class="special-icons">
								<li>
									<span class="fa fa-cogs"></span>
									<h3>비비드 보석</h3>
									<p>1+1 커플링 행사 있습니다</p>
								</li>
								<li>
									<span class="fa fa-wrench"></span>
									<h3>떡볶이</h3>
									<p>극강 매운 음식이 땡길때.</p>
								</li>
								<li>
									<span class="fa fa-leaf"></span>
									<h3>원주 농협</h3>
									<p>로컬푸드 장이 열렸습니다</p>
								</li>
							</ul>
						</div>
						<div class="4u">
							<ul class="special-icons">
								<li>
									<span class="fa fa-cogs"></span>
									<h3>자연드림</h3>
									<p>옥수수 행사 있습니다</p>
								</li>
								<li>
									<span class="fa fa-wrench"></span>
									<h3>반곡역</h3>
									<p>사진찍으러 오세요</p>
								</li>
								<li>
									<span class="fa fa-leaf"></span>
									<h3>아몰라</h3>
									<p>아몰라아몰라.</p>
								</li>
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
						<div class="3u">
							<a href="#" class="image"><img src="/images/placeholder.png" alt=""></a>
							<h3>중앙시장 비비드</h3>
							<p>여친이랑 가서 커플링 하나 했어요..번창하세요</p>
						</div>
						<div class="3u">
							<a href="#" class="image"><img src="/images/placeholder.png" alt=""></a>
							<h3>중앙시장 칼국수</h3>
							<p>숨은 맛집이 여기 있었네요...</p>
						</div>
						<div class="3u">
							<a href="#" class="image"><img src="/images/placeholder.png" alt=""></a>
							<h3>떡볶이</h3>
							<p>완전 매움 ㅠㅠ</p>
						</div>
						<div class="3u">
							<a href="#" class="image"><img src="/images/placeholder.png" alt=""></a>
							<h3>VR 체험장</h3>
							<p>아이들이 너무 좋아하네요. 또 올께요</p>
						</div>
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