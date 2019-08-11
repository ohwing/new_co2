<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="wrapper style4">
	<section class="container">
		<div class="row flush">
			<div style="width:100%">
				<form action="#" method="post">
					<div style="padding-bottom: 50px;">
						<input class="8u" type="text" placeholder="관광지 선택" style="display: inline; width: 50%;">
						<a class="button" href="#" style="display: inline">TOUR API 관광지 선택</a>
					</div>
					<div>
						<input class="8u" type="text" placeholder="검색어 입력" style="display: inline; width: 50%;">
						<a class="button" href="#" style="display: inline">검색</a>
					</div>
				</form>
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">번호</th>
				      <th scope="col">등록자</th>
				      <th scope="col">상가명</th>
				      <th scope="col">등록일</th>
				      <th scope="col"> - </th>
				    </tr>
				  </thead>
				  <tbody>
				    <c:forEach var="item" items="${sangaList}">
						<tr>
					      <th scope="row">${item.seq}</th>
					      <td>${item.email}</td>
					      <td><a href="/board/view?page=${item.seq}">${item.store_id}<a></td>
					      <td>${item.reg_dt}</td>
					      <td>
<%-- 					      	<c:choose> --%>
<%-- 					      		<c:when test=""> --%>
<%-- 					      			<a href="/board/regist?seq=${item.seq}">수정</a> --%>
<%-- 					      		</c:when> --%>
					      		
<%-- 					      	</c:choose> --%>
					      	
					      </td>
					    </tr>
					</c:forEach>
				  </tbody>
				</table>
				<p>상가등록  <a href="/board/regist">이동하기</a></p>
				<p>메인으로  <a href="/main/main">이동하기</a></p>
			</div>
		</div>
	</section>
</div>


	
