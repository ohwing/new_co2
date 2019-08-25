<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        
    	<!--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">-->
        <title>
            <decorator:title default="대한민국 골목 구석구석" />
        </title>

	<%-- <decorator:head /> --%>
<!-- 		<title>TourAPI</title> -->
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
		<script src="/js/jquery.min.js"></script>
		<script src="/js/jquery.dropotron.min.js"></script>
		<script src="/js/skel.min.js"></script>
		<script src="/js/skel-layers.min.js"></script>
		<script src="/js/init.js"></script>
		
		<script type="text/javascript" src="/validation/js/jquery.validate.js"></script>

		<noscript>
			<link rel="stylesheet" href="/css/skel.css" />
			<link rel="stylesheet" href="/css/style.css" />
			<link rel="stylesheet" href="/validation/css/screen.css" /> 
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
    </head>
    <body class="homepage">
		<div class="wrapper style1">
			
		<!-- Header -->
			<div id="header">
				<div class="container">
						
					<!-- Logo -->
					<h1><a href="#" id="logo">대한민국 골목 구석구석</a></h1>
					
					<!-- Nav -->
					<nav id="nav">
						<ul>
							<li><a href="/main/main">메인으로</a></li>
							<c:choose>
							    <c:when test="${login.email ne null}">
							        <li class="active"><a href="/main/logoutproc">로그아웃</a></li>
							    </c:when>
							 
							    <c:when test="${login.email eq null}">
							       	<li class="active"><a href="/main/login">로그인</a></li>
							    </c:when>
							</c:choose>
							
							<li><a href="/board/list">상가리스트</a></li>
							<li><a href="/main/sangaapi" target="_blank">골목 구석구석 API</a></li>
							<li><a href="http://api.visitkorea.or.kr" target="_blank">TourAPI</a></li>
							<li><a href="http://www.true-inno.com" target="_blank">True Innovation</a></li>
							<li><a href="http://visitkorea.or.kr" target="_blank">Contact Us</a></li>
						</ul>
					</nav>
				</div>
			</div>
			
		<!-- Banner -->
			<div id="banner">
				<section class="container">
					<span>대한민국 골목 구석구석은</span>
					<p>여러분들의 가게 홍보를 도와 드립니다.</p>
				</section>
			</div>

		</div>
        <decorator:body />
        
        <!-- Footer -->
		<div id="footer">
			<section class="container">			
				<ul class="icons">
					<li class="active"><a href="#" class="fa fa-facebook"><span>Facebook</span></a></li>
					<li><a href="#" class="fa fa-twitter"><span>Twitter</span></a></li>
					<li><a href="#" class="fa fa-dribbble"><span>Pinterest</span></a></li>
					<li><a href="#" class="fa fa-google-plus"><span>Google+</span></a></li>
				</ul>
				<hr />
			</section>
			
			<!-- Copyright -->
				<div id="copyright">
				    COPYRIGHT(C) 2019. C.O.2 TEAM. ALL RIGHTS RESERVED<br/>
					Design: <a href="http://templated.co">TEMPLATED</a> Images: <a href="http://unsplash.com">Unsplash</a> (<a href="http://unsplash.com/cc0">CC0</a>)
				</div>			
		</div>
        
<!--        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> -->
<!-- 		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script> -->
<!-- 		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script> -->
        <script>
        </script>
    </body>
</html>

