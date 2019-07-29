<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상가등록</title>
</head>
<body>
	<form action="/board/registproc" method="post">
<!-- 		관광지선택<input id="location" name="location" type="text"> -->
		도<input id="store_addr1" name="store_addr1" type="text">
		시/군/구<input id="store_addr2" name="store_addr2" type="text">
		관광지<input id="store_addr3" name="store_addr3" type="text">
		상가명입력<input id="store_id" name="store_id" type="text">
		홍보글입력<textarea id="event_comment" name="event_comment" rows="5" cols="5"></textarea>
		파일첨부<input id="filed" name="filed" type="file">
		<input type="submit">
	</form>
	<p><a href="/board/list">되돌아가기</a></p>
</body>
</html>