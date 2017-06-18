<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/sweetalert.css" type="text/css" rel="stylesheet" />
<link href="css/sweetalert2.css" type="text/css" rel="stylesheet" />
<link href="css/modal.css" type="text/css" rel="stylesheet" />
<!-- Custom CSS -->
<link href="css/business-casual.css" rel="stylesheet" />

<title>FantaBomber - Inviti</title>
</head>
<body>

	<%@ include file = "../fragments/navbar.html" %>


	<div class="container">
	
	<div class="row col-lg-12 box" >
		<hr>
			<h2 class="intro-text text-center">Inviti</h2>
		<hr>
		
		
		
		
		<div class="row  invito-Style" >
				<div class="col-lg-8  ">
					<p>Username</p>
				</div>
				<div class="col-lg-2 text center ">
					<button type="button" class="btn btn-lg btn-success "> Accetta </button>
				</div>
				<div class="col-lg-2 text-center">
					<button type="button" class="btn btn-lg btn-danger"> Rifiuta </button>
				</div>
		</div>
	
	
	
	
	
		
	</div>
		</div>
		<!--Banner pubblicità -->
		<div class="row">
			<div class="box">
				<div class="col-lg-12">
					<hr>
					<h2 class="intro-text text-center">
						Build a website <strong>worth visiting</strong>
					</h2>
					<hr>
					<div class="col-lg-4">
						<p>INSERIRE PUBBLICITA</p>
					</div>
					<div class="col-lg-4">
						<p>INSERIRE PUBBLICITA</p>
					</div>
					<div class="col-lg-4">
						<p>INSERIRE PUBBLICITA</p>
					</div>
				</div>
			</div>
		</div>


	</div>
	<!-- /.container -->

	<!--include footer -->
	<%@ include file = "../fragments/footer.html" %>
	<!-- jQuery -->
	<script src="Script/jquery-3.1.1.min.js" type="text/javascript"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/sweetalert.min.js"></script>
	<script src="js/sweetalert2.min.js"></script>
	<script src="Script/CreaCampionato.js"></script>
	<script src="Script/loginCampionato.js"></script>
	<script src="Script/modal.js"></script>
</body>
</html>