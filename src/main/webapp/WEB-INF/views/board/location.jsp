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
        	    // �ڱ� �ڽ��� ȣ���� �θ�â�� ������ ����
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
						<h2>������ ������ �ּ���</h2>
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
<!-- 									<h3><a href="./popupLocationGungu.html" >����</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">��⵵</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">������</a></h3> -->
<!-- 								</li> -->
							</ul>
<!-- 						</div> -->
<!-- 						<div class="4u"> -->
<!-- 							<ul class="special-icons"> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">��õ</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">������</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">��û����</a></h3> -->
<!-- 								</li> -->
<!-- 							</ul> -->
<!-- 						</div> -->
<!-- 						<div class="4u"> -->
<!-- 							<ul class="special-icons"> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">��û�ϵ�</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">���ϵ�</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">��󳲵�</a></h3> -->
<!-- 								</li> -->
<!-- 							</ul> -->
<!-- 						</div> -->
<!-- 						<div class="4u"> -->
<!-- 							<ul class="special-icons"> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">�λ�</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">�뱸</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">����</a></h3> -->
<!-- 								</li> -->
<!-- 							</ul> -->
<!-- 						</div> -->
<!-- 						<div class="4u"> -->
<!-- 							<ul class="special-icons"> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">�︪��</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">����</a></h3> -->
<!-- 								</li> -->
<!-- 								<li> -->
<!-- 									<span class="fa fa-leaf"></span> -->
<!-- 									<h3><a href="./popupLocationGungu.html">���ֵ�</a></h3> -->
<!-- 								</li> -->
<!-- 							</ul> -->
<!-- 						</div>						 -->
					</div>
				</section>
			</div>	