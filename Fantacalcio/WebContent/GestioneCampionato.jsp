<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Campionato"%>
<%@ page import="model.Squadra"%>
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

<!-- Table CSS -->
<link href="css/dataTables.bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<!-- sweetAlert CSS -->
<link href="css/sweetalert.css" type="text/css" rel="stylesheet" />
<link href="css/sweetalert2.css" type="text/css" rel="stylesheet" />


<!-- Custom CSS -->
<link href="css/business-casual.css" rel="stylesheet" />
<link href="css/formazioniStyle.css" rel="stylesheet" />


<title>FantaBomber - Gestione Campionato</title>

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
					<li><a class="btn btn-sm btn-info "
						href="LogoutAmministratore">Log Out</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>



	<div class="container">


		<div class="col-lg-12 ">
			<div id="campionato" class=" row box text-center">
				<hr>
				<h2>Gestisci Campionato ${NomeCampionato}</h2>
				<hr>
			</div>
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

							<%
								Campionato campionato = (Campionato) request.getAttribute("Campionato");
								if (campionato.getSquadre() == null) {
							%>

							<tr>
								<td colspan="3">Nessun utente</td>
							</tr>
							<%
								} else {
							%>
							<c:forEach var="p" items="${Campionato.squadre}">

								<tr>
									<td>${p.utente.username}</td>
									<td class="hidden-xs">${p.utente.nome}</td>
									<td class="hidden-xs">${p.utente.cognome}</td>
									<td>${p.nome}</td>
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
				<div class="row">
					<div class="  text-center">
						<div class="box">
							<hr>
							<h2 class="intro-text text-center">Crea giornata</h2>
							<hr>
							<div>
								<div>
									<label>Data prossima partita</label>
								</div>
								<div id="datepicker" style="margin: 1em"></div>
							</div>
							<br>
							<div>
								<button type="button" class="btn btn-primary"
									aria-label="Left Align" onclick="creaGiornata()">Crea</button>
							</div>
							<br>
						</div>



						<div class="box">
							<h4>Apri mercato</h4>
							<br> <label class="switch"> <c:choose>
									<c:when test="${Campionato.mercato}">
										<input type="checkbox" checked onclick="aperturaMercato()"
											id="mercato">
									</c:when>
									<c:otherwise>
										<input type="checkbox" onclick="aperturaMercato()"
											id="mercato">
									</c:otherwise>
								</c:choose>
								<div class="slider round"></div>

							</label><br>
							<br>
						</div>


					</div>
				</div>















				<div class="row ">
					<div class="box text-center">

						<hr>
						<h2 class="intro-text text-center">Calcola Giornata</h2>
						<hr>




						<form action="CalcolaRisultati" onclick="return calcola()">
							<input class="btn btn-primary" type="submit" value="Calcola" />
						</form>

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
						<%
							List<Utente> utenti = (List<Utente>) request.getAttribute("PossibiliPartecipanti");
							if (utenti.size() == 0) {
						%>

						<tr>
							<td colspan="3">Nessun utente</td>
						</tr>
						<%
							} else {
						%>
						<c:forEach var="p" items="${PossibiliPartecipanti}">

							<tr id="${p.username}">
								<td>${p.username}</td>
								<td class="hidden-xs">${p.nome}</td>
								<td class="hidden-xs">${p.cognome}</td>
								<td class="hidden-xs">${p.email}</td>
								<td class="text-center"><c:choose>
										<c:when test="${p.invito}">
											<input id="invita" type="submit" value="In Attesa"
												class="btn btn-info btn-sm" disabled="disabled">
										</c:when>
										<c:otherwise>
											<input id="invita" type="submit" value="Invita"
												class="btn btn-info btn-sm"
												onclick="invita('${p.username}','${Campionato.nome}')">
										</c:otherwise>
									</c:choose></td>
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


	<%@ include file="../fragments/footer.html"%>


	<!-- jQuery -->

<script src="Script/jquery-3.1.1.min.js" type="text/javascript"></script>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/sweetalert.min.js"></script>
	<script src="js/sweetalert2.min.js"></script>
	

	<!-- Table JavaScript library -->
	<script src="js/jquery.dataTables.min.js"></script>
	<script src="js/dataTables.bootstrap.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#datepicker").datepicker();
		});
	</script>

	<script src="Script/gestioneInviti.js"></script>
	<script src="Script/CreaGiornata.js"></script>
	<script src="Script/gestioneMercato.js"></script>
	<script src="Script/gestioneFormazione.js"></script>



</body>
</html>