<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
</head>
<body>
	<form action="/main/signupproc" method="post">
		<input id="email" name="email" type="email">
		<input id="pw" name="pw" type="password">	
		<input type="submit">
	</form>
</body>
</html>