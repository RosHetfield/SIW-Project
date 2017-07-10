<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" />

<!-- sweetAlert CSS -->
<link href="css/sweetalert.css" type="text/css" rel="stylesheet" />
<link href="css/sweetalert2.css" type="text/css" rel="stylesheet" />

<!-- Custom CSS -->
<link href="css/business-casual.css" rel="stylesheet" />

<title>FantaBomber - Calcola Giornata</title>

</head>

<body>

	<!-- Header/Navigation -->

	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">FantaBomber</span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
				<a class="navbar-brand">FantaBomber</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">

					<li><a class="btn btn-sm  " href="GestioneCampionato">Gestione Campionato</a></li>
					<li><a class="btn btn-sm btn-info "
						href="LogoutAmministratore">Log Out</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<div class="container">

		<div class="row">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3 box">

				<form method="post" enctype="multipart/form-data">
					<hr>
					<h2 class="intro-text text-center">
						<strong>Calcola giornata ${giornata }</strong>
					</h2>
					<hr>
					<div class="row col-lg-12">

						<div class="col-lg-6 col-sm-6 col-12">
							<input type="file" name="uploadFile" id="file"
								accept=".xls,.xlsx, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel" />

						</div>


					</div>
					<br> <br>


					<div class="col-lg-12">
						<input type="button" value="Calcola" id="btnUpload"
							class="btn-primary btn-lg btn-block">
					</div>



				</form>
			</div>
		</div>


	</div>
	<!-- /.container -->

	<%@ include file="../fragments/footer.html"%>

	<!-- jQuery -->
	<script src="Script/jquery-3.1.1.min.js" type="text/javascript"></script>

	<!-- Custom JavaScript -->
	<script src="Script/upload.js"></script>


	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/sweetalert.min.js"></script>
	<script src="js/sweetalert2.min.js"></script>

</body>

</html>
