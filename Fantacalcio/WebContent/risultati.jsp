<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Voto_giornata"%>
<%@ page import="model.Partita"%>
<%@ page import="model.Giocatore_in_formazione"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
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


<title>FantaBomber - Formazioni</title>

</head>

<body>

	<!-- Header/Navigation -->
	<%@ include file="../fragments/header.html"%>


	<div class="container">

		<div class="row">
			<div class="box ">
				<div class="col-lg-12 ">
					<ol class="list-inline">

						<li><button type="button"
								class="btn btn-primary  btn-sm myButton  ">2</button></li>
						<li><button type="button"
								class="btn btn-primary  btn-sm myButton  ">3</button></li>
						<li><button type="button"
								class="btn btn-primary  btn-sm myButton ">1</button></li>
						<li><button type="button"
								class="btn btn-primary  btn-sm myButton  ">2</button></li>
						<li><button type="button"
								class="btn btn-primary  btn-sm myButton  ">3</button></li>

					</ol>
				</div>
			</div>
		</div>
	</div>



	<div class="container">
		<div class=" box">



			<div class="row">
<% 	int giornata=(int)request.getAttribute("ultimaGiornata");
	if(giornata==-1){
%>
				<h3 class="text-center">
				<span>Nessun risultato presente<i
						class="pull-left "></i>
					</span>
				</h3>


<%}else{ %>
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
									<td colspan="8">In campo</td>
								</tr>


								<tr class="bg-slate-300">
									<td>Ruolo</td>

									<td>Nome Calciatore</td>

									<td class="text-center"><span class="hidden-xs">
											Voto</span> <span class="visible-xs" data-toggle="tooltip"
										title="Voto">V</span></td>

									<td class="text-center"><span class="hidden-xs">
											Fantavoto</span> <span class="visible-xs" data-toggle="tooltip"
										title="Fanta Voto">FV</span></td>

									<td class="text-center"><span class="hidden-xs">
											Squadra</span> <span class="visible-xs" data-toggle="tooltip"
										title="Squadra">S</span></td>
								</tr>

							</thead>
							<tbody>


								<c:forEach var="g" items="${inFormazione}">
									<c:if test="${p.nome==g.squadraGiocatoreRosa && g.titolare}">
										<tr class="">
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


											<td><span>${g.giocatoreInRosa.giocatore.nome} </span> <c:if
													test="${g.uscito}">
													<span class="fantaicon-uscito tip pull-right"
														data-toggle="tooltip" title="Uscito"> </span>
												</c:if> <c:if
													test="${mappaVoti[g.nomeGiocatoreRosa].ammonito == 1}">
													<span class="fantaicon-ammonizione tip"
														data-toggle="tooltip" title="Ammonito"> </span>
												</c:if> <c:if test="${mappaVoti[g.nomeGiocatoreRosa].espulso == 1}">
													<span class="fantaicon-espulsione tip"
														data-toggle="tooltip" title="Espulso"> </span>
												</c:if> <c:forEach var="n" begin="1"
													end="${mappaVoti[g.nomeGiocatoreRosa].goalFatto}" step="1">
													<span class="fantaicon-goal-fatto tip"
														data-toggle="tooltip" title="Goal fatto"> </span>
												</c:forEach> <c:forEach var="n" begin="1"
													end="${mappaVoti[g.nomeGiocatoreRosa].goalSuRigore}"
													step="1">
													<span class="fantaicon-goal-rigore tip"
														data-toggle="tooltip" title="Goal rigore"> </span>
												</c:forEach> <c:forEach var="n" begin="1"
													end="${mappaVoti[g.nomeGiocatoreRosa].goalSubito}" step="1">
													<span class="fantaicon-goal-subito tip"
														data-toggle="tooltip" title="Goal subito"> </span>
												</c:forEach> <c:forEach var="n" begin="1"
													end="${mappaVoti[g.nomeGiocatoreRosa].rigoreParato}"
													step="1">
													<span class="fantaicon-rigore-parato tip"
														data-toggle="tooltip" title="Rigore parato"> </span>
												</c:forEach> <c:forEach var="n" begin="1"
													end="${mappaVoti[g.nomeGiocatoreRosa].rigoreSbagliato}"
													step="1">
													<span class="fantaicon-rigore-sbagliato tip"
														data-toggle="tooltip" title="Rigore sbagliato"> </span>
												</c:forEach> <c:forEach var="n" begin="1"
													end="${mappaVoti[g.nomeGiocatoreRosa].autorete}" step="1">
													<span class="fantaicon-autogol tip" data-toggle="tooltip"
														title="Autorete"> </span>
												</c:forEach> <c:forEach var="n" begin="1"
													end="${mappaVoti[g.nomeGiocatoreRosa].assist}" step="1">
													<span class="fantaicon-assist tip" data-toggle="tooltip"
														title="Assist"> </span>
												</c:forEach> <c:if
													test="${mappaVoti[g.nomeGiocatoreRosa].goalVittoria == 1}">
													<span class="fantaicon-gol-vittoria tip"
														data-toggle="tooltip" title="Goal vittoria"> </span>
												</c:if> <c:if
													test="${mappaVoti[g.nomeGiocatoreRosa].goalPareggio == 1}">
													<span class="fantaicon-gol-pareggio tip"
														data-toggle="tooltip" title="Goal pareggio"> </span>
												</c:if></td>

											<td><span><c:out
														value='${mappaVoti[g.nomeGiocatoreRosa].voto}'></c:out> </span></td>

											<td><span><c:out
														value='${mappaVoti[g.nomeGiocatoreRosa].fantavoto}'></c:out>
											</span></td>


											<td><span class="hidden-xs">${g.giocatoreInRosa.giocatore.squadra}
											</span></td>

										</tr>
									</c:if>
								</c:forEach>

							</tbody>
							<thead>

								<tr class="active">
									<td colspan="8">In panchina</td>
								</tr>


								<tr class="bg-slate-300">
									<td>Ruolo</td>


									<td>Nome Calciatore</td>

									<td class="text-center"><span class="hidden-xs">
											Voto</span> <span class="visible-xs" data-toggle="tooltip"
										title="Voto">V</span></td>

									<td class="text-center"><span class="hidden-xs">
											Fantavoto</span> <span class="visible-xs" data-toggle="tooltip"
										title="Fanta Voto">FV</span></td>

									<td class="text-center"><span class="hidden-xs">
											Squadra</span> <span class="visible-xs" data-toggle="tooltip"
										title="Squadra">S</span></td>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="g" items="${inFormazione}">
									<c:if
										test="${p.nome==g.squadraGiocatoreRosa && not g.titolare}">
										<tr class="">
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

											<td><span>${g.giocatoreInRosa.giocatore.nome} </span> <c:if
													test="${g.entrato}">
													<span class="fantaicon-entrato tip pull-right"
														data-toggle="tooltip" title="Entrato"> </span>
												</c:if> <c:if
													test="${mappaVoti[g.nomeGiocatoreRosa].ammonito == 1}">
													<span class="fantaicon-ammonizione tip"
														data-toggle="tooltip" title="Ammonito"> </span>
												</c:if> <c:if test="${mappaVoti[g.nomeGiocatoreRosa].espulso == 1}">
													<span class="fantaicon-espulsione tip"
														data-toggle="tooltip" title="Espulso"> </span>
												</c:if> <c:forEach var="n" begin="1"
													end="${mappaVoti[g.nomeGiocatoreRosa].goalFatto}" step="1">
													<span class="fantaicon-goal-fatto tip"
														data-toggle="tooltip" title="Goal fatto"> </span>
												</c:forEach> <c:forEach var="n" begin="1"
													end="${mappaVoti[g.nomeGiocatoreRosa].goalSuRigore}"
													step="1">
													<span class="fantaicon-goal-rigore tip"
														data-toggle="tooltip" title="Goal rigore"> </span>
												</c:forEach> <c:forEach var="n" begin="1"
													end="${mappaVoti[g.nomeGiocatoreRosa].goalSubito}" step="1">
													<span class="fantaicon-goal-subito tip"
														data-toggle="tooltip" title="Goal subito"> </span>
												</c:forEach> <c:forEach var="n" begin="1"
													end="${mappaVoti[g.nomeGiocatoreRosa].rigoreParato}"
													step="1">
													<span class="fantaicon-rigore-parato tip"
														data-toggle="tooltip" title="Rigore parato"> </span>
												</c:forEach> <c:forEach var="n" begin="1"
													end="${mappaVoti[g.nomeGiocatoreRosa].rigoreSbagliato}"
													step="1">
													<span class="fantaicon-rigore-sbagliato tip"
														data-toggle="tooltip" title="Rigore sbagliato"> </span>
												</c:forEach> <c:forEach var="n" begin="1"
													end="${mappaVoti[g.nomeGiocatoreRosa].autorete}" step="1">
													<span class="fantaicon-autogol tip" data-toggle="tooltip"
														title="Autorete"> </span>
												</c:forEach> <c:forEach var="n" begin="1"
													end="${mappaVoti[g.nomeGiocatoreRosa].assist}" step="1">
													<span class="fantaicon-assist tip" data-toggle="tooltip"
														title="Assist"> </span>
												</c:forEach> <c:if
													test="${mappaVoti[g.nomeGiocatoreRosa].goalVittoria == 1}">
													<span class="fantaicon-gol-vittoria tip"
														data-toggle="tooltip" title="Goal vittoria"> </span>
												</c:if> <c:if
													test="${mappaVoti[g.nomeGiocatoreRosa].goalPareggio == 1}">
													<span class="fantaicon-gol-pareggio tip"
														data-toggle="tooltip" title="Goal pareggio"> </span>
												</c:if></td>

											<td><span><c:out
														value='${mappaVoti[g.nomeGiocatoreRosa].voto}'></c:out> </span></td>

											<td><span><c:out
														value='${mappaVoti[g.nomeGiocatoreRosa].fantavoto}'></c:out>
											</span></td>


											<td><span class="hidden-xs">${g.giocatoreInRosa.giocatore.squadra}
											</span></td>



										</tr>
									</c:if>
								</c:forEach>
								
								<c:forEach var="g" items="${risultatiGiornata.squadra==p.nome}">
								<tr class="bg-slate-300">
									<td colspan="3"><span>Totale </span></td>
									<td colspan="2"><span>${risultatiGiornata.totale}</span></td>
								</tr>
								</c:forEach>
								

							</tbody>

						</table>
					</div>

				</c:forEach>
<%} %>
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

	<script>
		$(document).ready(function() {
			$('[data-toggle="tooltip"]').tooltip();
		});
	</script>


</body>
</html>
