<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�����ȣ �˻�</title>
<!-- <script src="https://apis.openapi.sk.com/tmap/js?version=1&format=javascript&appKey=7a0d3672-8e3e-4cd6-9eef-af31d374fe2c"></script> -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans" rel="stylesheet">
 <style>
        * {
            padding: 0;
            margin: 0;
            border: 0;
            box-sizing: border-box;
        }
        
        body {
            color: #666;
            font-size: 15px;
            font-family: 'Noto Sans', sans-serif;
            word-break: keep-all;
            word-wrap: break-word;
            white-space: normal;
            line-height: 1.5;
            overflow: hidden;
        }
        
        table {
            width: 100%;
            border-spacing: 0;
            border-collapse: collapse;
        }
        
        a {
            color: inherit;
            text-decoration: none;
        }
        
        ul,
        ol {
            list-style: none;
        }
        
        .blind {
            position: absolute;
            overflow: hidden;
            clip: rect(0px, 0px, 0px, 0px);
            margin: 10px;
            width: 1px;
            height: 1px;
        }
        
        .mainDiv {
            width: 100%;
            position: relative;
			max-width: 600px;
			margin:auto;
        }
        
        /* -------TOP------- */
        
        #divtop {
            position: relative;
            background: #ff7a00;
            height: 45px;
            text-align: center;
        }
        
        #divtop h3 {
            width: 200px;
            height: 45px;
            line-height: 45px;
            margin: 0 auto;
        }
        
        #divtop .top_tit {
            font-size: 18px;
            font-weight: 400;
            position: relative;
            color: #fff;
        }
        /* -------CONTENT------- */
        
        #divSearch {
            padding: 15px 20px;
            /*background: beige;*/
        }
        
        #divSearch p {
            font-size: 14px;
            margin-top: 8px;
            margin-left: 15px;
            color: #333;
        }
        
        #divSearch p b {
            color: #ff7a00;
        }
        
        #divSearch .search_box {
            border-bottom: 2px solid #ff7a00;
            padding: 0 15px;
        }
        
        #divSearch .search_box .inputGrp {
            overflow: hidden;
        }
        
        .inputGrp .btn_sch {
            background: transparent;
            border: 0;
            float: right;
            height: 44px;
            line-height: 44px;
            outline: 0;
            position: relative;
        }
        
        .inputGrp .btn_sch .ico_sch {
            display: inline-block;
            width: 24px;
            height: 24px;
            line-height: 24px;
            position: relative;
            cursor: pointer;
            vertical-align: middle;
        }
        
        .inputGrp .btn_sch .ico_sch:before,
        .inputGrp .btn_sch .ico_sch:after {
            content: '';
            display: block;
            position: absolute;
            top: 0;
            left: 0;
        }
        
        .inputGrp .btn_sch .ico_sch:before {
            width: 13px;
            height: 13px;
            border: 2px solid #ff7a00;
            border-radius: 100%;
            -webkit-border-radius: 100%;
            -moz-border-radius: 100%;
        }
        
        .inputGrp .btn_sch .ico_sch:after {
            width: 2px;
            height: 10px;
            background: #ff7a00;
            transform: rotate(-45deg);
            -webkit-transform: rotate(-45deg);
            -moz-transform: rotate(-45deg);
            -o-transform: rotate(-45deg);
            -ms-transform: rotate(-45deg);
            top: 12px;
            left: 16px;
        }
        
        .inputGrp .input_sch {
            height: 44px;
            background: #fff;
            padding: 5px 9px 0 0px;
            overflow: hidden;
        }
        
        .inputGrp .input_sch input {
            border: none;
            padding: 0px;
            margin: 0px;
            width: 100%;
            height: 100%;
            outline: none;
            font-size: 17px;
        }
        
        #divSearchlist {
            background: #f4f4f4;
            padding: 20px;
            clear: both;
        }
        #divSearchlist .result {
            margin-bottom: 8px;
        }
        #divSearchlist .tb_wrap {
            height: 400px;
            overflow-y: auto;
        }
        
        #divSearchlist table {
            border-top: 1px solid #dbdbdb;
            border-bottom: 1px solid #dbdbdb;
        }
        
        #divSearchlist table thead * {
            height: 0ox;
            line-height: 0px;
            text-indent: -9999px;
            font-size: 0;
            color: #fff;
        }
        
        #divSearchlist table tbody td {
            background: #fff;
            padding: 10px 15px;
            border-bottom: 1px solid #dbdbdb;
        }
        
        ul.tb1 {
            display: table;
            width: 100%;
        }
        
        ul.tb1>li.row {
            display: table-row !important;
        }
        
        ul.tb1>li.row div:nth-child(2) {
            padding-bottom: 7px;
        }
        
        ul.tb1>li.row>div.th {
            display: table-cell;
            width: 70px;
        }
        
        ul.tb1>li.row span.label {
            display: inline-block;
            width: 60px;
            text-align: center;
            color: #fff;
            padding: 2px 5px;
            font-size: 13px;
            font-weight: 600;
        }
        
        ul.tb1>li.row span.st {
            background: #8faae4;
        }
        
        ul.tb1>li.row span.num {
            background: #b5bbd1;
        }
        
        ul.tb1>li.row .post {
            color: #ff2121;
            font-size: 18px;
        }
        
        /* Page navigation */
        #pageZone {
            padding: 5px 0;
            text-align: center;
        }
        
        .btn_pageNum {
            width: 35px;
            height: 30px;
            line-height: 30px;
            text-align: center;
            background-color: #f9f9f9;
            border: 1px solid #eeeeee;
            display: inline-block;
            color: inherit;
            font-size: 12px;
        }
        
        .btn_pageNum_active {
            background-color: #fce1d8;
        }
        
        .btn_pageNum:hover {
            background-color: #fef1ec;
        }
        
        .btn_pageNum:active {
            background-color: #fce1d8;
        }
</style>
</head>
<body>
<div class="mainDiv">
	<input type="hidden" id="inpPage" type="text" value="1">
	<input type="hidden" id="inpTotLimit" type="text" value="7">
    <div id="divtop">
            <h3>
                <span class="ico_sch"></span>
                <span class="top_tit">�����ȣ �˻�</span>
            </h3>
        </div>
        <div id="divcont">
            <div id="divSearch">
                    <fieldset class="search_box">
                        <legend class="blind">�˻��� �Է�â</legend>
                        <div class="inputGrp">
                            <button class="btn_sch" name="btn_sch" id="inpSearch">
                                <span class="ico_sch"></span>
                            </button>
                            <div class="input_sch">
                                <input type="text" id="inpKeyword" title="�˻�" placeholder="��) ������ 65, ������2�� 11">
                            </div>
                        </div>
                    </fieldset>
                <p>* �˻�â�� ã���ô� <b>���θ�+�ǹ���ȣ</b> �Ǵ� <b>������+����</b>�� �Է��� �ּ���.</p>
            </div>
            <div id="divSearchlist">
               <div class="result">
                   <p>�˻���� : �� <strong id="spanTotCnt">0</strong>��</p>
               </div>
                <div class="tb_wrap">
                    <table>
                        <caption class="blind">�˻���� ����Ʈ</caption>
                        <thead>
                            <tr>
                                <th>�����ȣ/���θ�/����</th>
                            </tr>
                        </thead>
                        <tbody id="tbodyResult">
                            
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div id="pageZone"></div>
	
	
	<script>
		function init(){
			$('#inpKeyword').focus();
		}
		
		function isValidate() {
			var keyword = $('#inpKeyword').val();
			var totLimit = $('#inpTotLimit').val();
			var page = $('#inpPage').val();
			
			if( $.trim( keyword ) == '' ) {
				alert('�˻�� �Է����ּ���.');
				return false;
			}
			
			if( $.trim( totLimit ) == '' || $.isNumeric( totLimit ) == false || totLimit <= 0 ) {
				$('#inpTotLimit').val('20');
			}
			
			if( $('#inpTotLimit').val() > 200 ) {
				$('#inpTotLimit').val('200');
				alert('200�� �̻��� �׸��� ��������ȣ�� �̿����ּ���.');
			}
			
			if( $.trim( page ) == '' || $.isNumeric( page ) == false || page <= 0 ) {
				$('#inpPage').val('1');
			}
			
			return true;
		}
		
		// �˻��� �Է� â
		$('#inpKeyword').keydown(function(e){
			if(e.keyCode == 13) {
				$('.btn_sch').trigger('click');
			}
		});
		
		// ������ �� �Է� â
		$('#inpPage').keydown(function(e){
			if(e.keyCode == 13) {
				$('.btn_sch').trigger('click');
			}
		});
		
		// �˻� ��� ���� �� �Է� â
		$('#inpTotLimit').keydown(function(e){
			if(e.keyCode == 13) {
				$('.btn_sch').trigger('click');
			}
		});
		
		// ����¡ Ŭ��
		function goPage(movePage){
			$('#inpPage').val(movePage);
			$('.btn_sch').trigger('click');
		}
		
		// �˻� ��ư
		$('#inpSearch').click(function(){
			// ��ȿ�� �˻�
			isValidate();
			
			var appKey='7a0d3672-8e3e-4cd6-9eef-af31d374fe2c';
			var url = 'https://apis.openapi.sk.com/tmap/geo/postcode';
		
			var params = {
					"coordType" : "WGS84GEO",
					"addressFlag" : "F00",
					"format" : "json",
					"page" : $('#inpPage').val(),
					"count" : $('#inpTotLimit').val(),
					"addr" : $('#inpKeyword').val(),
					"appKey" : appKey
			};
			$.get(url, params, success)
			 .fail(fail);
		});

		function success( data ) {
			var arrResult = data.coordinateInfo.coordinate;
			var error = data.error;
			var strHtml = '';
			
			var jibunAddr = '';
			var newRoadAddr = '';
			
			// ��ü �˻� ��
			var totalCnt = data.coordinateInfo.totalCount;
			$('#spanTotCnt').html( totalCnt );
			
			//����¡ ó��----------------------------------------------------------------
			var totalCnt = data.coordinateInfo.totalCount; //��ü �˻� �Ǽ�
			var totalPage = Math.ceil(totalCnt/$('#inpTotLimit').val());//������ ��
			var curentPage = $('#inpPage').val();//���� ������
			var pageHtml; //������ ����Ʈ
			
			var pageGroup = Math.ceil(curentPage/10);    //������ �׷� �ѹ���

			var next = pageGroup*10;
			var prev = next-9;            
			
			var goNext = next+1;
			if(prev-1<=0){
				var goPrev = 1;
			}else{
				var goPrev = prev-1;
			}    
			
			if(next>totalPage){
				var goNext = totalPage;
				next = totalPage;
			}else{
				var goNext = next+1;
			}
			
			if(totalPage>1){
				var prevStep = " <a class='btn_pre btn_pageNum' href='javascript:goPage("+goPrev+");'>��</a> ";
				var nextStep = " <a class='btn_nxt btn_pageNum' href='javascript:goPage("+goNext+");'>��</a> ";
			}
			
			$("#pageZone").empty();
			$("#pageZone").append(prevStep);
			for(var i=prev; i<=next;i++){
				if(curentPage == i){
					PageHtml = "<strong><a class='btn_pageNum btn_pageNum_active' href='javascript:goPage("+i+");'>"+i+"</a></strong> ";
				}else{
					PageHtml = "<strong><a class='btn_pageNum' href='javascript:goPage("+i+");'>"+i+"</a></strong> ";
				}
				$("#pageZone").append(PageHtml);
			}    
			$("#pageZone").append(nextStep);
			//����¡ ó��----------------------------------------------------------------			
			
			for( var i in arrResult ) {
				
				//������ ������ ���� 
				var lastLegal = arrResult[i].legalDong.charAt(arrResult[i].legalDong.length-1);
				
				// ���ּ� 
				newRoadAddr = arrResult[i].city_do + ' ' + arrResult[i].gu_gun + ' '; 
				
				if(arrResult[i].eup_myun == '' && (lastLegal=="��"||lastLegal=="��")){//����
					newRoadAddr +=  arrResult[i].legalDong;	
				}else{
					newRoadAddr +=  arrResult[i].eup_myun;
				}
				newRoadAddr += ' ' +arrResult[i].newRoadName + ' ' + arrResult[i].newBuildingIndex;
				
				// ���ּ� ������& �ǹ��� üũ
				if(arrResult[i].legalDong != '' && (lastLegal!="��"&&lastLegal!="��")){//�������� ������ ���� ���
					
					if(arrResult[i].buildingName != ''){//������ �����ϴ� ���
						newRoadAddr +=  (' (' + arrResult[i].legalDong + ', ' +arrResult[i].buildingName +') ');
					}else{
						newRoadAddr += (' (' + arrResult[i].legalDong + ')');
					}
				}else if(arrResult[i].buildingName != ''){//������ �����ϴ� ���
					newRoadAddr +=  (' (' + arrResult[i].buildingName +') ');
				}
				
				// ���ּ�
				jibunAddr = arrResult[i].city_do + ' ' + arrResult[i].gu_gun + ' ' + arrResult[i].legalDong + ' '+ arrResult[i].ri + ' ' + arrResult[i].bunji;
				//���ּ� ������ ����
				if(arrResult[i].buildingName != ''){//������ �����ϴ� ���
					jibunAddr +=  (' '+arrResult[i].buildingName);
				}
				
				
				strHtml+='<tr>';
				strHtml+='	<td>';
				strHtml+='		<ul class="tb1">';
				strHtml+='			<li class="row">';
				strHtml+='				<div class="th blind">�����ȣ</div>';
// 				strHtml+='				<div class="post"><a href="javascript:">'+ arrResult[i].zipcode +'</a></div>';
				strHtml+="				<div class='post'><a href='javascript:addrsend("+arrResult[i].zipcode+", \""+jibunAddr+"\")'>"+ arrResult[i].zipcode +"</a></div>";
				strHtml+='			</li>';
				strHtml+='			<li class="row">';
				strHtml+='				<div class="th"><span class="label st">���θ�</span></div>';
				strHtml+="				<div><a href='javascript:addrsend("+arrResult[i].zipcode+", \""+jibunAddr+"\")'>" + newRoadAddr + "</a></div>";
				strHtml+='			</li>';
				strHtml+='			<li class="row">';
				strHtml+='				<div class="th"><span class="label num">����</span></div>';
				strHtml+="				<div><a href='javascript:addrsend("+arrResult[i].zipcode+", \""+jibunAddr+"\")'>" + jibunAddr + "</a></div>";
				strHtml+='			</li>';
				strHtml+='		</ul>';
				strHtml+='	</td>';
				strHtml+='</tr>';
				
			}
			if( error || arrResult.length <= 0 ) {
				strHtml+='<tr>';
				strHtml+='	<td colspan="2">';
				strHtml+='		<span>�˻������ �����ϴ�.</span>';
				strHtml+='	</td>';
				strHtml+='</tr>';
			}
			
			$('#tbodyResult').html(strHtml);
		}
		
		function addrsend(zipcode, jibunAddr){
			window.opener.document.getElementById("store_addr1").value = zipcode;
			window.opener.document.getElementById("store_addr2").value = jibunAddr;
			window.close();
		}
		
		
		
		function fail(){
			var strHtml="";
			strHtml+='<tr>';
			strHtml+='	<td>';
			strHtml+='		<span>�˻������ �����ϴ�.</span>';
			strHtml+='	</td>';
			strHtml+='</tr>';
			
			$('#spanTotCnt').html( '0' );
			$('#tbodyResult').html(strHtml);
		}
		
		$(function(){
			init();
			
		});
	</script>
</div>	
</body>
</html>
