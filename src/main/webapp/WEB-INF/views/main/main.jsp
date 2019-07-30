<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>메인페이지</title>
</head>
<body>
	<p>user : ${login.email}</p>
	<p>user : ${login}</p>
	<p>user : ${login.pw}</p>
	
	<c:choose>
	    <c:when test="${login.email ne null}">
	        <p>로그아웃 <a href="/main/logoutproc">하기</a></p>
	    </c:when>
	 
	    <c:when test="${login.email eq null}">
	       	<p>로그인 <a href="/main/login">이동하기</a></p>
	    </c:when>
	</c:choose>
	<p>회원가입 <a href="/main/signup">이동하기</a></p>
	<p>상가등록하기 <a href="/board/regist">이동하기</a></p>
	<p>상가리스트보러가기 <a href="/board/list">이동하기</a></p>
</body>
</html>