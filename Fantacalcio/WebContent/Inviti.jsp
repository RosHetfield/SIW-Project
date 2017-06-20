<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%@ page
import="model.Campionato"%> <%@ page import="model.Squadra"%> <%@ page
import="model.Utente"%> <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/sweetalert.css" type="text/css" rel="stylesheet" />
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
		
		
		
		
		<c:forEach var="i" items="${Inviti}">
			<div id="${i.utente}" class="row  invito-Style" >
				<div class="col-lg-8  ">
					<p>Campionato "<i>${i.campionato}</i>"</p>
				</div>
				<div class="col-lg-2 text center ">
					<button type="button" class="btn btn-lg btn-success " onclick="accettaInvito('${i.utente}','${i.campionato}','a','${i.utente}')"> Accetta </button>
				</div>
				<div class="col-lg-2 text-center">
					<button type="button" class="btn btn-lg btn-danger" onclick="rifiutaInvito('${i.utente}','${i.campionato}','r','${i.utente}')"> Rifiuta </button>
				</div>
			</div>
		</c:forEach>
	
	
	
	
	
		
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
	<script src="Script/gestioneInviti.js"></script>
	<script src="Script/loginCampionato.js"></script>
	<script src="Script/modal.js"></script>
</body>
</html>