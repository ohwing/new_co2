<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
       <c:when test="${param.listpage ne null}">
           <script type="text/javascript">
           			function fpopup(title, contentid) {
           				window.opener.document.getElementById("list_tour_search").value = title;
           				window.close();
       				}
			</script>
       </c:when>
       <c:when test="${param.listpage eq null}">
           <script type="text/javascript">
           function fpopup(title, contentid) {
        	    // 자기 자신을 호출한 부모창에 데이터 전달
        	    window.opener.document.getElementById("tour_addr3").value = title;
        	    window.opener.document.getElementById("api_tourkey_id").value = contentid;
        	    window.close();
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
								<c:forEach var="data" items="${location}">
									<li class="location_list">
										<span class="fa fa-leaf"></span>
										<h3><a href="javascript:fpopup('${data.value}', ${data.key})" >${data.value}</a></h3>
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