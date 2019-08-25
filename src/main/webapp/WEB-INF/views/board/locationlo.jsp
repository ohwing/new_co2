<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("euc-kr"); %>


<c:choose>
       <c:when test="${param.listpage ne null}">
           <script type="text/javascript">
           			function fpopup(datakey, datavalue) {
       					window.location.href = "/board/locationgungu?listpage=toursearch&areaCode="+datakey;
       				}
			</script>
       </c:when>
       <c:when test="${param.listpage eq null}">
           <script type="text/javascript">
				function fpopup(datakey, datavalue) {
		// 			window.open("/board/locationgungu?areaCode="+datakey);
					window.opener.document.getElementById("tour_addr1").value = datavalue;
					window.location.href = "/board/locationgungu?areaCode="+datakey;
				}
		   </script>
       </c:when>
</c:choose>
<!-- Section Three -->

			<div class="wrapper style4">
				<section class="container">
					<header class="major">
						<h2>지역을 선택해 주세요</h2>
					</header>
					<div class="row flush">
						<ul class="special-icons">
							<c:forEach var="data" items="${areaCode}">
								<li class="location_list">
									<span class="fa fa-leaf"></span>
									<h3><a href="javascript:fpopup(${data.key}, '${data.value}')" >${data.value}</a></h3>
								</li>
							</c:forEach>
						</ul>
					</div>
				</section>
			</div>	