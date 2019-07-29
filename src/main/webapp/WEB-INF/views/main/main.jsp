<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	<p>로그인 <a href="/main/login">이동하기</a></p>
	<p>회원가입 <a href="/main/signup">이동하기</a></p>
	<p>상가등록하기 <a href="/board/regist">이동하기</a></p>
	<p>상가리스트보러가기 <a href="/board/list">이동하기</a></p>
</body>
</html>