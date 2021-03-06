<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.List"%>
<%@ page import="model.Classifica"%>
<!DOCTYPE html>
<html lang="en">
<head>


<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>FantaBomber - Classifica</title>


<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" />

<!-- datatables CSS -->
<link href="css/dataTables.bootstrap.min.css" rel="stylesheet" />

<!-- Custom CSS -->
<link href="css/business-casual.css" rel="stylesheet" />
<link href="css/formazioniStyle.css" rel="stylesheet" />

<!-- Navbar CSS -->
<link href="css/sweetalert.css" type="text/css" rel="stylesheet" />
<link href="css/modal.css" type="text/css" rel="stylesheet" />
<link href="css/sweetalert2.css" type="text/css" rel="stylesheet" />



<title>Fanta Bomber</title>
</head>

<body>

	<!-- Navigation -->
	<%@ include file="../fragments/navbar.html"%>
	<%@ include file="../fragments/homeNavbar.html"%>


	<div class="container">
		<%
			List<Classifica> c = (List<Classifica>) request.getAttribute("classifica");
			if (c.isEmpty()) {
		%>
		<div class="row ">
			<div class="col-lg-12  box">
				<hr>
				<h2 class="intro-text text-center">Nessuna Classifica</h2>
				<hr>
			</div>
		</div>
		<%
			} else {
		%>


		<!-- indice giornate -->
		<div class="row">
			<div class="box text-center">
				<hr>
				<h5>Giornate</h5>
				<hr>
				<div class="col-lg-12 ">
					<ol class="list-inline">
						<c:forEach var="name" begin="1" end="${giornata}" step="1">
							<li><button type="button"
									onclick="caricaGiornata('${name}')"
									class="btn btn-sm btn-primary myButton" id="${name}">
									${name}</button></li>
						</c:forEach>

					</ol>
				</div>
			</div>
		</div>

		<!-- tabella classifica -->
		<div class="row ">
			<div class="col-lg-12  box">

				<h3 class="text-center">
					<span>Classifica Giornata ${giornataStorico} <i
						class="pull-left "></i>
					</span>
				</h3>


				<table id="tabellaClassifica"
					class="table table-striped table-bordered">
					<thead class="bg-slate-300">
						<tr>
							<th>Posizione</th>
							<th>Squadra</th>
							<th class="hidden-xs" title="Giocate">Partite giocate</th>
							<th title="Totale">Totale</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="c" items="${classifica }" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${c.squadra }</td>
								<td class="hidden-xs">${c.partite_giocate }</td>
								<td title="Totale">${c.totale }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<%
					}
				%>
			</div>
		</div>






	</div>
	<!-- /.container -->

	<!--include footer -->
	<%@ include file="../fragments/footer.html"%>





	<!-- jQuery -->
	<script src="Script/jquery-3.1.1.min.js" type="text/javascript"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<script src="js/sweetalert.min.js"></script>
	<script src="js/sweetalert2.min.js"></script>

	<!-- Table JavaScript library -->
	<script src="js/jquery-1.12.4.js"></script>
	<script src="js/jquery.dataTables.min.js"></script>
	<script src="js/dataTables.bootstrap.min.js"></script>


	<!-- Custom JavaScript -->
	<script src="Script/modal.js"></script>
	<script src="Script/storicoClassifica.js"></script>
	<script src="Script/loginCampionato.js"></script>
	<script src="Script/modal.js"></script>
	<script src="Script/gestioneFormazione.js"></script>
	<script src="Script/gestioneMercato.js"></script>


	<script type="text/javascript">
		$(document).ready(function() {
			$('#tabellaClassifica').DataTable();
		});
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#Classifica').css({
				'background-color' : '#e7e7e7'
			});
		});
	</script>


</body>

</html>
