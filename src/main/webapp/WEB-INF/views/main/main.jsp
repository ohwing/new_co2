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
								<h2>����Ʈ�� ���� �÷��̿��� Ȯ���ϼ���!</h2>
								<span class="byline">�ȵ���̵� ���� �÷��̿��� '���ѹα� ���'���������� �˻��ϼż� ��ġ �ϼ���!</span>
							</header>
						</div>
						<div class="6u">
							<h3>�������� ���Ը� ȫ���ϼ���</h3>
							<p>�ڿ����� �Ͻô� �� �̶�� ������ ȸ�� �����ϼż� ȸ������ ���Ը� ȫ�� �ϼ���!</p>
							<c:choose>
								<c:when test="${login.email ne null}">
									<a href="/board/regist" class="button">�󰡵���Ϸ� ����</a>		
								</c:when>
								
								<c:when test="${login.email eq null}">
									<a href="/main/signup" class="button">ȸ�� �����Ϸ� ����</a>	
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
						<h2>�̴��� �ֽ� ��� ����</h2>
						<span class="byline">�������� ���Կ� ����� ��� �մϴ�.</span>
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
						<h2>�̴��� Best �湮�� ����</h2>
						<span class="byline">���� ���ؼ� �����п��� �帮�� ������ �޽��� �Դϴ�!</span>
					</header>
					<div class="row">
						<c:forEach var="rank" items="${rankList}">
							<div class="3u">
								<a href="/board/view?page=${rank.sanga_seq}" class="image">
									<c:choose>
										<c:when test="${rank.atchmnfl_mask_nm ne null}">
										<!-- ���� -->
										<img style="border: none; border-radius: 0; border-color: none; width: 162px; height: 162px;" src="/fileupload/${rank.atchmnfl_mask_nm}" alt="">
										<!-- ���߰�� -->
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
									<p>����: ${rank.rank}</p>
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
<!-- <title>����������</title> -->
<!-- </head> -->
<!-- <body> -->
<%-- 	<p>user : ${login.email}</p> --%>
<%-- 	<p>user : ${login}</p> --%>
<%-- 	<p>user : ${login.pw}</p> --%>
	
<%-- 	<c:choose> --%>
<%-- 	    <c:when test="${login.email ne null}"> --%>
<!-- 	        <p>�α׾ƿ� <a href="/main/logoutproc">�ϱ�</a></p> -->
<%-- 	    </c:when> --%>
	 
<%-- 	    <c:when test="${login.email eq null}"> --%>
<!-- 	       	<p>�α��� <a href="/main/login">�̵��ϱ�</a></p> -->
<%-- 	    </c:when> --%>
<%-- 	</c:choose> --%>
<!-- 	<p>ȸ������ <a href="/main/signup">�̵��ϱ�</a></p> -->
<!-- 	<p>�󰡵���ϱ� <a href="/board/regist">�̵��ϱ�</a></p> -->
<!-- 	<p>�󰡸���Ʈ�������� <a href="/board/list">�̵��ϱ�</a></p> -->
<!-- </body> -->
<!-- </html> -->