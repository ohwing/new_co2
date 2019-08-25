<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
/*   height: calc(1.5em + 0.75rem + 2px); */
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
/*   height: calc(1.5em + 1rem + 2px); */
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

p {
	margin: 0;
}

@media (min-width: 768px){
	.text-center{
		text-align: center;
	}
}

/* Image Card */
.card-group { 
	     display: -ms-flexbox; 
	     display: flex; 
	     -ms-flex-direction: column; 
	     flex-direction: column; 
	 } 
		 
 	@media (min-width: 576px){ 
	 	.card-group { 
		     -ms-flex-flow: row; 
		     flex-flow: row; 
		 } 
		 
 	} 
 

 @media (min-width: 576px){ 
	 .card-group>.card:not(:last-child) { 
	     border-top-right-radius: 0; 
	     border-bottom-right-radius: 0; 
	 } 
 } 
 @media (min-width: 576px){ 
	 .card-group>.card { 
	     -ms-flex: 100%; 
	     flex: 100%; 
	     margin-bottom: 0; 
	 } 
 } 
 .card-group>.card { 
     margin-bottom: 15px; 
 } 
 .card { 
     position: relative; 
     display: -ms-flexbox; 
     display: flex; 
     -ms-flex-direction: column; 
     flex-direction: column; 
     min-width: 0; 
     word-wrap: break-word; 
     background-color: #fff; 
     background-clip: border-box; 
     border: 1px solid rgba(0,0,0,.125); 
     border-radius: .25rem; 
 } 


 @media (min-width: 576px){ 
	 .card-group>.card:not(:last-child) .card-header, .card-group>.card:not(:last-child) .card-img-top { 
	     border-top-right-radius: 0; 
	 } 
 } 
 .card-img-top { 
     width: 100%; 
     border-top-left-radius: calc(.25rem - 1px); 
     border-top-right-radius: calc(.25rem - 1px); 
 } 
 img { 
     vertical-align: middle; 
     border-style: none; 
 }
 
 .card-title {
	  margin-bottom: 0.75rem;
	}
 /* Image Card */ 
 
 hr {
  margin-top: 1rem;
  margin-bottom: 1rem;
  border: 0;
  border-top: 1px solid rgba(0, 0, 0, 0.1);
}

</style>

<div class="wrapper style4">
	<section class="container">
		<div class="row1 flush">
			<div style="width:100%">
				
				<div class="form-group row1">
					<p class="col-sm-12 col-md-2 col-form-label col-form-label-lg text-center">글 번호</p>
					<div class="col-sm-12 col-md-10" style="margin-bottom: 3px;">
				      <p class="form-control form-control-lg">${sangaView.seq}번</p>
				    </div>
				    
				    <p class="col-sm-12 col-md-2 col-form-label col-form-label-lg text-center">등록일, 수정일</p>
				    <div class="col-sm-12 col-md-10" style="margin-bottom: 3px;">
				      <p class="form-control form-control-lg">${sangaView.reg_dt}, ${sangaView.mod_dt}</p>
				    </div>
				    
				    <p class="col-sm-12 col-md-2 col-form-label col-form-label-lg text-center">등록자</p>
					<div class="col-sm-12 col-md-10" style="margin-bottom: 3px;">
				      <p class="form-control form-control-lg">${sangaView.email}</p>
				    </div>
				
					<p class="col-sm-12 col-md-2 col-form-label col-form-label-lg text-center">상가명</p>
					<div class="col-sm-12 col-md-10" style="margin-bottom: 3px;">
				      <p class="form-control form-control-lg">${sangaView.store_id}</p>
				    </div>
				    
				    <p class="col-sm-12 col-md-2 col-form-label col-form-label-lg text-center">관광지</p>
					<div class="col-sm-12 col-md-10" style="margin-bottom: 3px;">
				      <p class="form-control form-control-lg">${sangaView.tour_addr3}</p>
				    </div>
				    
				    <p class="col-sm-12 col-md-2 col-form-label col-form-label-lg text-center">상가주소</p>
					<div class="col-sm-12 col-md-10" style="margin-bottom: 3px;">
				      <p class="form-control form-control-lg">${sangaView.store_addr2} ${sangaView.store_addr3}</p>
				    </div>
				    
				    <p class="col-sm-12 col-md-2 col-form-label col-form-label-lg text-center">홍보글</p>
					<div class="col-sm-12 col-md-10" style="margin-bottom: 3px;">
				      <pre class="form-control form-control-lg" style="height: 100%;">${sangaView.event_comment}</pre>
				    </div>
				 </div>
				 
				  	<c:choose>
				  		<c:when test="${sangaImageView ne null}">
				  			<h5 class="card-title" style="margin-top:5%;">상가이미지</h5>
				  		</c:when>
				  	</c:choose>
				    <div class="card-group">
				      <c:forEach var="item" items="${sangaImageView}">
				      	
				      	<div class="card">
<!-- 				      		개발경로 -->
<%-- 						   <img src="/upload/images/${item.atchmnfl_mask_nm}" class="card-img-top" alt="..."> --%>
<!-- 						         운영경로 -->
						   <img src="/fileupload/${item.atchmnfl_mask_nm}" class="card-img-top" alt="...">
						</div>
				      </c:forEach>
					</div>
					
				   <div class="container" style="margin-left: auto; margin-right: none;">
				    <div style="width: 100%;">
				    <div class="row1" style="flex-direction: row-reverse;">
				    <c:choose>
					    <c:when test="${login.email eq sangaView.email}">
					    <a class="btn col-xl-2 col-md-2" href="/board/regist?seq=${sangaView.seq}">수정</a>
			        	    <c:choose>
					   	    	<c:when test="${sangaView.file_id eq 0 }">
					   	    		<a class="btn col-xl-2 col-md-2" href="/board/deleteproc?seq=${sangaView.seq}&store_id=${sangaView.store_id}>삭제</a>
					   	    	</c:when>
					   	    	<c:when test="${sangaView.file_id ne 0 }">
					   	    		<a class="btn col-xl-2 col-md-2" href="/board/deleteproc?seq=${sangaView.seq}&file=${sangaImageView.get(0).file_id}&store_id=${sangaView.store_id}">삭제</a>
					   	    	</c:when>
					   	    </c:choose>       	   
					    </c:when>
					 </c:choose>
				     <a class="btn col-xl-2 col-md-2" href="/board/list">목록</a>
				     </div>
				     </div>
				    </div>
				    
				    <hr>
			    <div class="form-group row1">
		    	<c:forEach var="comment" items="${tourCommentRank}">
		    		<div class="col-sm-12 col-md-12" style="display: inline-flex;">
		    			<p>Email: ${comment.reg_user_id}</p>
		    			<p style="padding-left: 10px;">등록일 : ${comment.reg_dt}</p>
				    	<p style="padding-left: 10px;">평점 : ${comment.rank}</p>
					</div>
						
					<div class="col-sm-12 col-md-12" style="margin-bottom: 3px;">
				      <pre class="form-control form-control-lg" style="height: 100%;">${comment.rank_comment}</pre>
				    </div>
				    <hr style="width: 100%">
				 </c:forEach>
				 </div>
			</div>
		</div>
	</section>
</div>