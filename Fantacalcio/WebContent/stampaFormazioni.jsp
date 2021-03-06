<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Giocatore_in_formazione"%>
<%@ page import="model.Partita"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" />

<!-- Custom CSS -->
<link href="css/business-casual.css" rel="stylesheet" />
<link href="css/formazioniStyle.css" rel="stylesheet" />

<!-- Navbar CSS -->
<link href="css/sweetalert.css" type="text/css" rel="stylesheet" />
<link href="css/modal.css" type="text/css" rel="stylesheet" />
<link href="css/sweetalert2.css" type="text/css" rel="stylesheet" />


<title>FantaBomber - Formazioni</title>

</head>

<body>

	<!-- Header/Navigation -->
	<%@ include file="../fragments/navbar.html"%>

	<%@ include file="../fragments/homeNavbar.html"%>

	<div class="container">
		<div class=" box">


			<%
				int p = (int) request.getAttribute("ultimaGiornata");
				if (p == -1) {
			%>
			<h3 class="text-center">
				<span>Nessuna giornata presente </span>
			</h3>


			<%
				} else {
					List<Giocatore_in_formazione> formazioni = (List<Giocatore_in_formazione>) request
							.getAttribute("giocatoriUltima");
					if (formazioni.size() == 0) {
			%>

			<h3 class="text-center">
				<span>Nessuna formazione inserita per la giornata
					${ultimaGiornata} </span>
			</h3>


			<c:forEach var="p" items="${squadreCampionato}">
				<div class="col-lg-6 ">
					<hr>
					<h3 class="text-center">

						<span>${p.nome} </span>
					</h3>
					<hr>
				</div>
			</c:forEach>

			<%
				} else {
			%>




			<div class="row">
				<h3 class="text-center">

					<span>Formazioni giornata ${ultimaGiornata} <i
						class="pull-left "></i>
					</span>
				</h3>




				<c:forEach var="p" items="${squadreCampionato}">
					<div class="col-lg-6 ">
						<hr>
						<h3 class="text-center">

							<span>${p.nome} </span>
						</h3>
						<hr>

						<table class="table table-striped table-bordered"
							id="players_list">
							<thead>

								<tr class="active">
									<td colspan="8" class="text-center"><h5>In campo</h5></td>
								</tr>


								<tr class="bg-slate-300">

									<td>Ruolo</td>


									<td>Nome Calciatore</td>


									<td><span class="hidden-xs"> Squadra</span></td>

								</tr>
							</thead>
							<tbody>


								<c:forEach var="g" items="${giocatoriUltima}">
									<c:if test="${p.nome==g.squadraGiocatoreRosa && g.titolare}">
										<tr>
											<c:choose>
												<c:when test="${g.giocatoreInRosa.giocatore.ruolo == 'P'}">
													<td class="valign-top"><span class="label label-1">${g.giocatoreInRosa.giocatore.ruolo}</span><br
														class="visible-xs"></td>
												</c:when>
												<c:when test="${g.giocatoreInRosa.giocatore.ruolo == 'D'}">
													<td class="valign-top"><span class="label label-2">${g.giocatoreInRosa.giocatore.ruolo}</span><br
														class="visible-xs"></td>
												</c:when>
												<c:when test="${g.giocatoreInRosa.giocatore.ruolo == 'C'}">
													<td class="valign-top"><span class="label label-3">${g.giocatoreInRosa.giocatore.ruolo}</span><br
														class="visible-xs"></td>
												</c:when>
												<c:when test="${g.giocatoreInRosa.giocatore.ruolo == 'A'}">
													<td class="valign-top"><span class="label label-4">${g.giocatoreInRosa.giocatore.ruolo}</span><br
														class="visible-xs"></td>
												</c:when>
											</c:choose>


											<td><span>${g.giocatoreInRosa.giocatore.nome} </span></td>

											<td><span class="hidden-xs">${g.giocatoreInRosa.giocatore.squadra}
											</span></td>

										</tr>
									</c:if>
								</c:forEach>

							</tbody>
							<thead>

								<tr class="active">
									<td colspan="8" class="text-center"><h5>In panchina</h5></td>
								</tr>


								<tr class="bg-slate-300">

									<td>Ruolo</td>


									<td>Nome Calciatore</td>


									<td><span class="hidden-xs"> Squadra</span></td>

								</tr>
							</thead>
							<tbody>

								<c:forEach var="g" items="${giocatoriUltima}">
									<c:if
										test="${p.nome==g.squadraGiocatoreRosa && not g.titolare}">
										<tr>
											<c:choose>
												<c:when test="${g.giocatoreInRosa.giocatore.ruolo == 'P'}">
													<td class="valign-top"><span class="label label-1">${g.giocatoreInRosa.giocatore.ruolo}</span><br
														class="visible-xs"></td>
												</c:when>
												<c:when test="${g.giocatoreInRosa.giocatore.ruolo == 'D'}">
													<td class="valign-top"><span class="label label-2">${g.giocatoreInRosa.giocatore.ruolo}</span><br
														class="visible-xs"></td>
												</c:when>
												<c:when test="${g.giocatoreInRosa.giocatore.ruolo == 'C'}">
													<td class="valign-top"><span class="label label-3">${g.giocatoreInRosa.giocatore.ruolo}</span><br
														class="visible-xs"></td>
												</c:when>
												<c:when test="${g.giocatoreInRosa.giocatore.ruolo == 'A'}">
													<td class="valign-top"><span class="label label-4">${g.giocatoreInRosa.giocatore.ruolo}</span><br
														class="visible-xs"></td>
												</c:when>
											</c:choose>


											<td><span>${g.giocatoreInRosa.giocatore.nome} </span></td>

											<td><span class="hidden-xs">${g.giocatoreInRosa.giocatore.squadra}
											</span></td>

										</tr>
									</c:if>
								</c:forEach>

							</tbody>

						</table>
					</div>

				</c:forEach>


				<%
					}
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

	<!-- Custom JavaScript -->
	<script src="Script/modal.js"></script>
	<script src="Script/loginCampionato.js"></script>
	<script src="Script/gestioneFormazione.js"></script>
	<script src="Script/gestioneMercato.js"></script>
	<script>
		$(document).ready(function() {
			$('[data-toggle="tooltip"]').tooltip();
		});
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#Formazioni').css({
				'background-color' : '#e7e7e7'
			});
		});
	</script>

	

</body>
</html>
