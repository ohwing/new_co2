<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
       <c:when test="${param.listpage ne null}">
           <script type="text/javascript">
           			function fpopup(areaCode, datakey, datavalue) {
       					window.location.href = "/board/location?listpage=toursearch&areaCode="+areaCode+"&gungu="+datakey
       				}
			</script>
       </c:when>
       <c:when test="${param.listpage eq null}">
           <script type="text/javascript">
		   		function fpopup(areaCode, datakey, datavalue) {
		// 			window.open("/board/locationgungu?areaCode="+datakey);
					window.opener.document.getElementById("tour_addr2").value = datavalue;
					window.location.href = "/board/location?areaCode="+areaCode+"&gungu="+datakey
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
<!-- 						<div class="4u"> -->
							<ul class="special-icons">
								<c:forEach var="data" items="${gungu}">
									<li class="location_list">
										<span class="fa fa-leaf"></span>
<%-- 										<h3><a href="/board/location?areaCode=${areacode}&gungu=${data.key}" >${data.value}</a></h3> --%>
										<h3><a href="javascript:fpopup(${areacode}, ${data.key}, '${data.value}')" >${data.value}</a></h3>
									</li>
								</c:forEach>
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html" >서울</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">경기도</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">강원도</a></h3> -->
<!-- 								</li> -->
							</ul>
<!-- 						</div> -->
<!-- 						<div class="4u"> -->
<!-- 							<ul class="special-icons"> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">인천</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">세종시</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">충청남도</a></h3> -->
<!-- 								</li> -->
<!-- 							</ul> -->
<!-- 						</div> -->
<!-- 						<div class="4u"> -->
<!-- 							<ul class="special-icons"> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">충청북도</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">경상북도</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">경상남도</a></h3> -->
<!-- 								</li> -->
<!-- 							</ul> -->
<!-- 						</div> -->
<!-- 						<div class="4u"> -->
<!-- 							<ul class="special-icons"> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">부산</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">대구</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">광주</a></h3> -->
<!-- 								</li> -->
<!-- 							</ul> -->
<!-- 						</div> -->
<!-- 						<div class="4u"> -->
<!-- 							<ul class="special-icons"> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">울릉도</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">독도</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">제주도</a></h3> -->
<!-- 								</li> -->
<!-- 							</ul> -->
<!-- 						</div>						 -->
					</div>
				</section>
			</div>	