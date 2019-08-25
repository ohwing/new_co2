<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
	function fpopup() {
		window.open("/board/locationlo");
	}
	
	function addrpopup(){
		window.open("/board/searchaddr");
	}
</script>

<<style>
	.error {
		color: red;
	}
</style>
		<!-- Section Three -->
			<c:choose>
		        <c:when test="${updataValues.seq ne null}">
		            <form action="/board/updateproc" method="post" enctype="multipart/form-data" id="regform">
		                <input type="hidden" id="page" name="page" value="${updataValues.seq}">
		                <input type="hidden" id="file" name="file" value="${updataValues.file_id}">
		        </c:when>
		        <c:when test="${updataValues.seq eq null}">
		            <form action="/board/registproc" method="post" enctype="multipart/form-data" id="regform">
		        </c:when>
		    </c:choose>
			<div class="wrapper style4">
				<section class="container">
					<div class="row flush">
						<div class="8u">
							<ul class="special-icons">
								<li>
									<h3>관광지 선택</h3>
									<p style="margin: 0px; padding:0px;">API 관광지 선택 : <a href="javascript:fpopup()">검색</a></p>
							        <input id="tour_addr3" name="tour_addr3" type="text" style="width:100%" readonly value="${updataValues.tour_addr3}">
									<input id="tour_addr1" name="tour_addr1" type="hidden" style="width:100%" readonly value="${updataValues.tour_addr1}">
									<input id="tour_addr2" name="tour_addr2" type="hidden" style="width:100%" readonly value="${updataValues.tour_addr2}">
									<input id="api_tourkey_id" name="api_tourkey_id" type="hidden" style="width:100%" readonly value="${updataValues.api_tourkey_id}">
								</li>
								<li>
									<h3>상가 주소</h3>
									<p style="margin: 0px; padding:0px;">상가 주소 검색 : <a href="javascript:addrpopup()">검색</a></p>
						            <input class="store_addr" id="store_addr1" name="store_addr1" type="text" value="${updataValues.store_addr1}" placeholder="우편번호" readonly="readonly">
									<input class="store_addr" id="store_addr2" name="store_addr2" type="text" value="${updataValues.store_addr2}" placeholder="주소" readonly="readonly">
									<input class="store_addr" id="store_addr3" name="store_addr3" type="text" value="${updataValues.store_addr3}" placeholder="나머지주소">
								</li>
								<li>
									<h3>상가명 입력</h3>
									<input id="store_id" name="store_id" type="text" style="width:100%" value="${updataValues.store_id}">
								</li>
								<li>
									<h3>홍보글 입력</h3>
									<textarea id="event_comment" name="event_comment" rows="5" cols="5">${updataValues.event_comment}</textarea>
								</li>
								<li>
									<input multiple="multiple" id="imgFiled" name="imgFiled" type="file">
								</li>
								<li>
									<input class="button" type="submit" value="버튼을 눌러 완료하세요" />
								</li>
							</ul>
						</div>
						
						
					</div>
				</section>
			</div>
			</form>
			
<script type="text/javascript">
$(function() {
    $("#regform").validate({ rules: { 
    	
    // id , name 은 폼태그내에 존재하는 name명이다. 
        tour_addr3 : { 
        	//해당 옵션을 주면 필수체크! 
        	required : true 
        }, 
        store_addr1 : { 
       		required : true
       	}, 
       	store_addr2 : { 
       		required : true
       	},
       	store_addr3 : { 
       		required : true
       	},
       	store_id : {
       		required : true
       	},
       	event_comment : {
       		required : true
       	}
    }, 
		messages: { 
			// id , name 은 폼태그내에 존재하는 name명이다. 
			// alert에 들어가는 문자내용 
			// 하지만 text로만 화면에 보여진다는 것! 
   			tour_addr3: { 
   				required: "관광지를 선택해주세요." 
   			}, 
   			store_addr1: { 
   				required: "우편번호를 입력해주세요." 
   			}, 
   			store_addr2: { 
   				required: "주소를 입력해주세요." 
   			}, 
   			store_addr3: { 
   				required: "나머지주소를 입력해주세요." 
   			}, 
   			store_id: { 
   				required: "상가명을 입력해주세요." 
   			}, 
   			event_comment: { 
   				required: "홍보내용을 입력해주세요." 
   			}
		}, 
		//검증이 끝난후에 작업할 부분 (submit??) 
		submitHandler: function(form) { 
			form.submit();
		} 
	}); 
});
</script>
