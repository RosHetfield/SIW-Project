<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Utente"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />



<!-- Custom CSS -->
<link href="css/business-casual.css" rel="stylesheet" />
<link href="css/formazioniStyle.css" rel="stylesheet" />


<title>FantaBomber - Amministratore</title>

</head>
<body>


	<!-- Header/Navigation -->
	<div id="headload"></div>

	<div class="container">


		<div class="row">
			<div class="col-lg-9 ">
				<div class="box">

					<hr>
					<h2 class="intro-text text-center">Partecipanti</h2>
					<hr>

					<table id="tabellaPartecipanti" class="table table-striped table-bordered">
						<thead class="bg-slate-300">
							<tr>
								<th class="hidden-xs">Nome</th>
								<th class="hidden-xs">Cognome</th>
								<th>Username</th>
							</tr>
						</thead>
						<tfoot class="bg-slate-300">
							<tr>
								<th class="hidden-xs">Nome</th>
								<th class="hidden-xs">Cognome</th>
								<th>Username</th>
							</tr>
						</tfoot>
						<tbody>

							<%
								List<Utente> utenti = (List<Utente>) request.getAttribute("listaUtenti");
								if (utenti.size() == 0) {
							%>

							<tr>
								<td colspan="3">Nessun utente</td>
							</tr>
							<%
								} else {
							%>
							<c:forEach var="p" items="${listaUtenti}">

								<tr>
									<td class="hidden-xs">${p.nome}</td>
									<td class="hidden-xs">${p.cognome}</td>
									<td>${p.username}</td>
								</tr>

							</c:forEach>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>






			<div class="col-lg-3 ">
				<div class="row box text-center">
					<hr>
					<h2 class="intro-text text-center">Crea giornata</h2>
					<hr>



				</div>

				<div class="row box text-center">
					<hr>
					<h2 class="intro-text text-center">Calcola Giornata</h2>
					<hr>
					<!-- Single button -->
					<div class="btn-group">
						<button class="btn btn-default btn-lg dropdown-toggle"
							type="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
							Giornata N° <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
						</ul>
					</div>


					<div>
						<button type="button" class="btn btn-default"
							aria-label="Left Align">Calcola</button>
					</div>
				</div>
			</div>
		</div>




		<!-- tabella aggiungi -->

		<div class="col-lg-12 ">
			<div class=" row box">

				<hr>
				<h2 class="intro-text text-center">Aggiungi giocatore</h2>
				<hr>

				<table id="tabellaAggiungi" class="table table-striped table-bordered">
					<thead class="bg-slate-300">
						<tr>
							<th class="hidden-xs">Nome</th>
							<th class="hidden-xs">Cognome</th>
							<th>Username</th>
							<th></th>

						</tr>
					</thead>
					<tfoot class="bg-slate-300">
						<tr>
							<th class="hidden-xs">Nome</th>
							<th class="hidden-xs">Cognome</th>
							<th>Username</th>
							<th></th>

						</tr>
					</tfoot>


					<tbody>
							<%
								List<Utente> possibiliUtenti = (List<Utente>)request.getAttribute("listaPossibiliUtenti");
								if (possibiliUtenti.size() == 0) {
							%>

							<tr>
								<td colspan="3">Nessun utente</td>
							</tr>
							<%
								} else {
							%>
							<c:forEach var="p" items="${listaPossibiliUtenti}">

							<tr>
							<td class="hidden-xs">${p.nome}</td>
							<td class="hidden-xs">${p.cognome}</td>
							<td>${p.username}</td>
							<th>u buttun agg</th>
							</tr>

							</c:forEach>
							<%
								}
							%>
					</tbody>
				</table>
			</div>
		</div>






	</div>


	<!-- /.container -->


	<div id="footload"></div>

	<!-- jQuery -->
	<script src="Script/jquery-3.1.1.min.js" type="text/javascript"></script>

	<!--include header/footer -->
	<script type="text/javascript">
		$(document).ready(function() {
			$(function() {
				$("#headload").load("fragments/header.html");
			});
			$(function() {
				$("#footload").load("fragments/footer.html");
			});
		});
		
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#tabellaPartecipanti').DataTable();
		});
	</script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#tabellaAggiungi').DataTable();
		});
	</script>


	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>


</body>
</html>