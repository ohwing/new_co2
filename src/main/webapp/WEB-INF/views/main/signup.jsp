<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    

<!DOCTYPE HTML>
<!DOCTYPE html PUBLIC "" "">
<HTML lang="ko">

<HEAD>
    <META content="IE=11.0000" http-equiv="X-UA-Compatible">
    <!-- SITE TITTLE -->
    <META charset="utf-8">
    <META http-equiv="X-UA-Compatible" content="IE=edge">
    <META name="viewport" content="width=device-width, initial-scale=1">
    <TITLE>대한민국 골목 구석구석</TITLE> <!-- PLUGINS CSS STYLE -->
    <!-- Bootstrap -->
    <LINK href="/css/login_css/bootstrap.min.css" rel="stylesheet"> <!-- Themefisher Font -->
    <LINK href="/css/login_css/style.css" rel="stylesheet"> <!-- Owl Carousel -->
    <LINK href="/css/login_css/owl.carousel.min.css" rel="stylesheet" media="screen">
    <!-- Owl Carousel Theme -->
    <LINK href="/css/login_css/owl.theme.green.min.css" rel="stylesheet" media="screen">
    <!-- Fancy Box -->
    <LINK href="/css/login_css/jquery.fancybox.min.css" rel="stylesheet">
    <!-- CUSTOM CSS -->
    <LINK href="/css/login_css/style(1).css" rel="stylesheet">
    <!-- FAVICON -->
    <LINK href="/images/login_images/favicon.png" rel="shortcut icon">
    <META name="GENERATOR" content="MSHTML 11.00.9600.19404">
    
    <link rel="stylesheet" href="/validation/css/screen.css" /> 
</HEAD>

<style>
	.main.form-control{
		margin-bottom: 0px;
	}
	
	.error {
		display: block;
		text-align: left;
	}
	
	#pw-error {
		display: block;
		text-align: left;
	}
</style>

<BODY class="body-wrapper">
    <SECTION class="user-login section">
        <DIV class="container">
            <DIV class="row">
                <DIV class="col-12">
                    <DIV class="block">
                        <!-- Image -->
                        <DIV class="image align-self-center"><IMG class="img-fluid" alt="desk-image" src="/images/login_images/front-desk-sign-in.jpg"></DIV><!-- Content -->
                        <DIV class="content text-center">
                            <DIV class="logo"></DIV>
                            <DIV class="title-text">
                                <H3>이메일을 입력하세요</H3>
                            </DIV>
                            <FORM action="/main/signupproc" method="post" id="signup">
                                <!-- Username -->
                                <div style="margin-bottom: 20px;">
                                	<INPUT class="form-control main" required="" type="email" id="email" name="email" placeholder="Username" value=""><!-- Password -->
                                </div>
                                <div style="margin-bottom: 20px;">
                                	<INPUT class="form-control main" required="" type="password" id="pw" name="pw" placeholder="Password" value=""><!-- Submit Button -->
                                </div>
                                <input class="btn btn-main-md" type="submit" value="회원가입"/>
                                
                            </FORM>
                        </DIV>
                    </DIV>
                </DIV>
            </DIV>
        </DIV>
    </SECTION><!-- JAVASCRIPTS -->
    <SCRIPT src="/js/login_js/js.js" defer="" async=""></SCRIPT>
    <SCRIPT src="/js/login_js/jquery.js"></SCRIPT>
    <SCRIPT src="/js/login_js/popper.min.js"></SCRIPT>
    <SCRIPT src="/js/login_js/bootstrap.min.js"></SCRIPT>
    <SCRIPT src="/js/login_js/owl.carousel.min.js"></SCRIPT>
    <SCRIPT src="/js/login_js/jquery.fancybox.min.js"></SCRIPT>
    <SCRIPT src="/js/login_js/SmoothScroll.min.js"></SCRIPT>
    <SCRIPT src="/js/login_js/jquery.syotimer.min.js"></SCRIPT>
    <SCRIPT src="/js/login_js/custom.js"></SCRIPT>
    <script type="text/javascript" src="/validation/js/jquery.validate.js"></script>
    <script>
		$(function() {
	        $("#signup").validate({ rules: { 
	        	
	        // id , name 은 폼태그내에 존재하는 name명이다. 
		        email : { 
		        	//해당 옵션을 주면 필수체크! 
		        	required : true 
		        }, 
		       	pw : { 
		       		required : true,
		       		minlength: 4
		       	} 
	        }, 
				messages: { 
	   			// id , name 은 폼태그내에 존재하는 name명이다. 
	   			// alert에 들어가는 문자내용 
	   			// 하지만 text로만 화면에 보여진다는 것! 
		   			email: { 
		   				required: "이메일을 입력하세요." 
		   			}, 
		   			pw: { 
		   				required: "패스워드를 입력해주세요.",
		   				minlength: "패스워드는 최소 4자리 이상이어야 합니다."
		   			} 
				}, 
				//검증이 끝난후에 작업할 부분 (submit??) 
				submitHandler: function() { 
					alert("전송!!"); 
				} 
			}); 
		});
	</script>
    
    
</BODY>

</HTML>
    
    
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="EUC-KR"> -->
<!-- <title>회원가입</title> -->
<!-- </head> -->
<!-- <body> -->
<!-- 	<form action="/main/signupproc" method="post"> -->
<!-- 		<input id="email" name="email" type="email"> -->
<!-- 		<input id="pw" name="pw" type="password">	 -->
<!-- 		<input type="submit"> -->
<!-- 	</form> -->
<!-- </body> -->
<!-- </html> -->