<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%@ page
import="model.Campionato"%> <%@ page import="model.Squadra"%> <%@ page
import="model.Utente"%> <%@page import="java.util.List"%>

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

	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Amministratore</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
				<a class="navbar-brand">Amministratore</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a class="btn btn-sm btn-info " href="LogoutAministratore">Log Out</a>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>



	<div class="container">


		<div class="col-lg-12 ">
			<div class=" row box text-center"><h2>${nome}</h2></div>
		</div>


		<div class="row">
			<div class="col-lg-9 ">
				<div class="box">

					<hr>
					<h2 class="intro-text text-center">Partecipanti</h2>
					<hr>

					<table id="tabellaPartecipanti"
						class="table table-striped table-bordered">
						<thead class="bg-slate-300">
							<tr>
								<th>Username</th>
								<th class="hidden-xs">Nome</th>
								<th class="hidden-xs">Cognome</th>
								<th>Squadra</th>
							</tr>
						</thead>

						<tbody>

							<% Campionato campionato = (Campionato)
							request.getAttribute("Campionato"); if (campionato.getSquadre()
							== null) { %>

							<tr>
								<td colspan="3">Nessun utente</td>
							</tr>
							<% } else { %>
							<c:forEach var="p" items="${Campionato.squadre}">

								<tr>
									<td>${p.utente.username}</td>
									<td class="hidden-xs">${p.utente.nome}</td>
									<td class="hidden-xs">${p.utente.cognome}</td>
									<td>${p.nome}</td>
								</tr>

							</c:forEach>
							<% } %>
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

				<table id="tabellaAggiungi"
					class="table table-striped table-bordered">
					<thead class="bg-slate-300">
						<tr>
							<th>Username</th>
							<th class="hidden-xs">Nome</th>
							<th class="hidden-xs">Cognome</th>
							<th class="hidden-xs">Email</th>
							<th></th>

						</tr>
					</thead>



					<tbody>
						<% List
						<Utente> utenti = (List<Utente>)
						request.getAttribute("PossibiliPartecipanti"); if (utenti.size()
						== 0) { %>

						<tr>
							<td colspan="3">Nessun utente</td>
						</tr>
						<% } else { %> 
						<c:forEach var="p" items="${PossibiliPartecipanti}">

							<tr>
								<td>${p.username}</td>
								<td class="hidden-xs">${p.nome}</td>
								<td class="hidden-xs">${p.cognome}</td>
								<td class="hidden-xs">${p.email}</td>
								<td class="text-center">
									<button type="button" class="btn btn-sm btn-info "> Invita </button>
								</td>
							</tr>

						</c:forEach> <% } %> 
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
			$(function() {
				$("#footload").load("fragments/footer.html");
			});
		});
		
	</script>


	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#tabellaPartecipanti').DataTable();
		});
	</script>
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#tabellaAggiungi').DataTable();
		});
	</script>

</body>
</html>