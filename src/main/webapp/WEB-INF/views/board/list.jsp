<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
<style>

.row1 {
  display: -ms-flexbox;
  display: flex;
  -ms-flex-wrap: wrap;
  flex-wrap: wrap;
  margin-right: -15px;
  margin-left: -15px;
}

.col-form-label {
  padding-top: calc(0.375rem + 1px);
  padding-bottom: calc(0.375rem + 1px);
  margin-bottom: 0;
  font-size: inherit;
  line-height: 1.5;
}

.col-form-label-lg {
  padding-top: calc(0.5rem + 1px);
  padding-bottom: calc(0.5rem + 1px);
  font-size: 1.25rem;
  line-height: 1.5;
}

.form-group {
  margin-bottom: 1rem;
}
.form-group {
    display: -ms-flexbox;
    display: flex;
    -ms-flex: 0 0 auto;
    flex: 0 0 auto;
    -ms-flex-flow: row wrap;
    flex-flow: row wrap;
    -ms-flex-align: center;
    align-items: center;
    margin-bottom: 0;
  }
  
  #colFormLabelLg, .form-control {
  display: block;
  width: 100%;
  height: calc(1.5em + 0.75rem + 2px);
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  background-color: #fff;
  background-clip: padding-box;
  border: solid 1px #82b440;
  border-radius: 0.25rem;
  transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}

#list_store_search, #list_tour_search, .form-control-lg {
  height: calc(1.5em + 1rem + 2px);
  padding: 0.5rem 1rem;
  font-size: 1.25rem;
  line-height: 1.5;
  border-radius: 0.3rem;
  width:100%;
}

input[type="submit"], .btn {
  display: inline-block;
  font-weight: 400;
  text-align: center;
  vertical-align: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  background-color: white;
  border: 1px solid #82b440;
  padding: 0.675rem 2.25rem;
  font-size: 1rem;
  line-height: 1.5;
  border-radius: 0.25rem;
  transition: color 0.15s ease-in-out, background-color 0.15s ease-in-out, border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
  text-decoration: none;
  width:100%;
  max-width: 100%;
}

.btn:hover {
  color: white;
  background-color: #82b440;
  text-decoration: none;
}

.btn:focus, .btn.focus {
  outline: 0;
  box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
}

/* 페이징 네비게이션 */
.pagination {
    display: -ms-flexbox;
    display: flex;
    padding-left: 0;
    list-style: none;
    border-radius: .25rem;
}

.justify-content-center {
    -ms-flex-pack: center!important;
    justify-content: center!important;
}
 
 .page-link {
	    position: relative;
	    display: block;
	    padding: .5rem .75rem;
	    margin-left: -1px;
	    line-height: 1.25;
	    color: #82b440;
	    background-color: #fff;
	    border: 1px solid #dee2e6;
	    text-decoration: none;
	}
	
  .page-item.active .page-link {
	  z-index: 1;
	  color: #fff;
	  background-color: #82b440;
	  border-color: #82b440;
	}
	
	/* 페이징 네비게이션 */


</style>

<script type="text/javascript">

function searchLocation() {
	window.open("/board/locationlo?listpage=toursearch");
}

function pagePrev(){
	uri = window.location.href;
	if(uri.indexOf("search") != "search"){
		var list_prev_page = $("#list_prev_page");
		list_prev_page.attr("action", "")
	}	
}

function pageNext(){
	if(uri.indexOf("search") == 'search'){
		window.location.href = window.location.href + "&" + prev;
	} else {
		window.location.href = window.location.href + "?" + prev;
	}
}

function pageMove(move){
	uri = window.location.href;
	if(uri.indexOf("searchlist") == 28){
		if(uri.indexOf("page") != -1){
			var uri = uri.slice(0,-1);
			window.location.href = uri + move;
		} else {
			window.location.href = window.location.href + "&page=" + move;	
		}
	} else {
		window.location.href = "/board/list?page=" + move;
	}
}

</script>

<div class="wrapper style4">
	<section class="container">
		<div class="row flush">
			<div style="width:100%">
				<form action="/board/searchlist" method="get">
				 <input type="hidden" id="gubun" name="gubun" value="gubun">
				 <div class="form-group row1">
				    <label for="colFormLabelLg" class="col-sm-12 col-md-12 col-form-label col-form-label-lg">관광지</label>
				    <div class="col-sm-12 col-md-10" style="margin-bottom: 3px;">
				      <a href="javascript:searchLocation()"><input type="text" class="form-control form-control-lg" id="list_tour_search" name="list_tour_search" placeholder="관광지를 선택해주세요." readonly="readonly"></a>
				    </div>
				    <div class="col-sm-4 col-md-2">
				      <a class="btn" href="javascript:searchLocation()">선택</a>
				    </div>
				 </div>
				 
				 <div class="form-group row1" style="margin-bottom: 10px;">
					<input type="hidden" id="gubun" name="gubun" value="gubun">
				    <label for="colFormLabelLg" class="col-sm-12 col-md-12 col-form-label col-form-label-lg">상 가</label>
				    <div class="col-sm-12 col-md-10" style="margin-bottom: 3px;">
				      <input type="text" class="form-control form-control-lg" id="list_store_search" name="list_store_search" placeholder="상가를 입력해주세요.">
				    </div>
				    <div class="col-sm-4 col-md-2">
				      <input class="btn" type="submit" value="검색">
				    </div>
				 </div>
				</form>

				<table class="table table-bordered" style="text-align: center;">
				  <thead>
				    <tr>
				      <th scope="col">관광지</th>
				      <th scope="col">상가명</th>
				    </tr>
				  </thead>
				  <tbody>
				    <c:forEach var="item" items="${sangaList}">
						<tr>
					      <td style="width: 50%">${item.tour_addr1} ${item.tour_addr2} ${item.tour_addr3}</td>
					      <td><a href="/board/view?page=${item.seq}">${item.store_id}<a></td>
					    </tr>
					</c:forEach>
				  </tbody>
				</table>
				
				
				
				<nav aria-label="Page navigation">
				  <ul class="pagination justify-content-center">
				  	<c:if test="${pageMaker.prev}">
<%-- 				    	<li class="page-item"><a class="page-link" href="/board/list?page=${pageMaker.startPage-1}">이전</a></li> --%>
				    	<li class="page-item"><a class="page-link" href="javascript:pageMove(${pageMaker.startPage-1})">이전</a></li>
				    </c:if>
				    <c:forEach var="idx" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
					    <li class="page-item<c:out value="${pageMaker.criteria.page == idx ? ' active' : ''}"/>">
<%-- 					    	<a class="page-link" href="/board/list?page=${idx}">${idx}</a> --%>
					    	<a class="page-link" href="javascript:pageMove(${idx})">${idx}</a>
					    </li>
				    </c:forEach>
				    <c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
<%-- 				    	<li class="page-item"><a class="page-link" href="/board/list?page=${pageMaker.endPage+1}">다음</a></li> --%>
				    	<li class="page-item"><a class="page-link" href="javascript:pageMove(${pageMaker.endPage+1})">다음</a></li>
				    </c:if>
				  </ul>
				</nav>
				<div class="form-group row1" style="margin-bottom: 10px;">
			      	<div class="col-sm-4 offset-sm-8 col-md-3 offset-md-9 col-lg-3 offset-lg-9 col-xl-2 offset-xl-10" >
			      		<a class="btn" href="/board/regist">상가등록</a>
			    	</div>
				 </div>
			</div>
		</div>
	</section>
</div>

<form id="list_move_page">
		<input type="hidden" name="page" value="${idx}"/>
</form>
<form id="list_prev_page">
		<input type="hidden" name="page" value="${pageMaker.startPage-1}"/>
</form>
<form id="list_next_page">
		<input type="hidden" name="page" value="${pageMaker.endPage+1}"/>
</form>


	
