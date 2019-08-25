<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>Insert title here</title>
</head>
<body>
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
<script type="text/javascript">
// $("#thisis").carousel("pause");
</script>

<style>
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
	    color: #007bff;
	    background-color: #fff;
	    border: 1px solid #dee2e6;
	    text-decoration: none;
	}
	
  .page-item.active .page-link {
	  z-index: 1;
	  color: #fff;
	  background-color: #007bff;
	  border-color: #007bff;
	}
	
 
</style>

<div class="card-group">
  <div class="card">
    <img src="/upload/images/eetstst_2019_08_12_09594327bbdab488364a4a9b933539afdb9cd5.JPG" class="card-img-top" alt="...">
  </div>
  <div class="card">
    <img src="/upload/images/간월산간월산_2019_08_19_0155143baa38cdb1f740dca86858981242d2b4.jpg" class="card-img-top" alt="...">
  </div>
  <div class="card">
    <img src="/upload/images/이미지테스트했다_2019_08_07_10061149b1a0f2088a46cf8481e79caa89bb53.JPG" class="card-img-top" alt="...">
  </div>
</div>

<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
    <li class="page-item active"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item"><a class="page-link" href="#">Next</a></li>
  </ul>
</nav>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</body>
</html>