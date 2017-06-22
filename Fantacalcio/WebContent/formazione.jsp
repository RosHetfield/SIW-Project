<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Giocatore"%>
<%@ page import="model.Giocatore_in_formazione"%>
<%@ page import="model.Giocatore_in_rosa" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Set"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">




<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" />

<!-- Table CSS -->
<link href="css/dataTables.bootstrap.min.css" rel="stylesheet" />

<!-- sweetAlert CSS -->
<link href="css/sweetalert.css" type="text/css" rel="stylesheet" />

<!-- Custom CSS -->
<link href="css/business-casual.css" rel="stylesheet" />
<link href="css/formazioniStyle.css" rel="stylesheet" />


<title>FantaBomber - Formazione</title>

</head>

<body>

	<!-- Header/Navigation -->
	<%@ include file="../fragments/header.html"%>


	<div class="container">


		<div class=" row">
			<div class="box">
				<div class="col-lg-12 ">

					<hr>
					<h2 class="intro-text text-center">Formazione</h2>
					<hr>

					<table class="table " id="players_list">
						<tbody>

							<tr class="bg-slate-300">

								<td class=" "><span class="hidden-xs"> Ruolo</span> <span
									class="visible-xs" data-toggle="tooltip" title="Ruolo">R</span>
								</td>

								<td colspan="3">Nome Calciatore</td>

								<td class=""><span class="hidden-xs"> Squadra</span> <span
									class="visible-xs" data-toggle="tooltip" title="Squadra">S</span>
								</td>

								<td class="text-center"></td>
							</tr>

							<%
								Set<Giocatore_in_formazione> inFormazione = (Set<Giocatore_in_formazione>) request.getAttribute("giocatoriInFormazione");

								if (inFormazione.size() == 0) {
							%>
							<tr>
								<td colspan="7">Nessun giocatore</td>
							</tr>
							<%
								} else {
							%>
							<c:forEach var="p" items="${giocatoriInFormazione}">

								<tr>

									<c:choose>
										<c:when test="${p.giocatoreInRosa.giocatore.ruolo == 'P'}">
											<td class="valign-top" colspan="3"><span
												class="label label-1">${p.giocatoreInRosa.giocatore.ruolo}</span><br
												class="visible-xs"></td>
										</c:when>
										<c:when test="${p.giocatoreInRosa.giocatore.ruolo == 'D'}">
											<td class="valign-top" colspan="3"><span
												class="label label-2">${p.giocatoreInRosa.giocatore.ruolo}</span><br
												class="visible-xs"></td>
										</c:when>
										<c:when test="${p.giocatoreInRosa.giocatore.ruolo == 'C'}">
											<td class="valign-top" colspan="3"><span
												class="label label-3">${p.giocatoreInRosa.giocatoreruolo}</span><br
												class="visible-xs"></td>
										</c:when>
										<c:when test="${p.giocatoreInRosa.giocatore.ruolo == 'A'}">
											<td class="valign-top" colspan="3"><span
												class="label label-4">${p.giocatoreInRosa.giocatore.ruolo}</span><br
												class="visible-xs"></td>
										</c:when>
									</c:choose>


									<td class=""><span class="" data-toggle="tooltip"
										title="Nome">${p.giocatoreInRosa.giocatore.nome}</span></td>

									<td class=""><span class="" data-toggle="tooltip"
										title="Squadra">${p.giocatoreInRosa.giocatore.squadra} </span></td>

									<td class="text-center"><span class=""
										data-toggle="tooltip" title="Voto">6.00 </span></td>
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











		<!-- tabella rosa -->

		<div class=" row ">
			<div class="  box ">
				<div class=" col-lg-12 ">

					<hr>
					<h2 class="intro-text text-center">Rosa</h2>
					<hr>

					<div class="row">

						<table id="tabellaRosa"
							class="table table-striped table-bordered">
							<thead class="bg-slate-300">
								<tr>
									<th>Ruolo</th>
									<th class="hidden-xs">Nome Calciatore</th>
									<th class="hidden-xs">Squadra</th>
									<th class="text-center"></th>
								</tr>
							</thead>



							<tbody>



								<c:forEach var="p" items="${giocatoriInRosa}">
									<tr>

										<c:choose>
											<c:when test="${p.giocatore.ruolo == 'P'}">
												<td class="valign-top" ><span
													class="label label-1">${p.giocatore.ruolo}</span><br
													class="visible-xs"></td>
											</c:when>
											<c:when test="${p.giocatore.ruolo == 'D'}">
												<td class="valign-top" ><span
													class="label label-2">${p.giocatore.ruolo}</span><br
													class="visible-xs"></td>
											</c:when>
											<c:when test="${p.giocatore.ruolo == 'C'}">
												<td class="valign-top" ><span
													class="label label-3">${p.giocatore.ruolo}</span><br
													class="visible-xs"></td>
											</c:when>
											<c:when test="${p.giocatore.ruolo == 'A'}">
												<td class="valign-top" ><span
													class="label label-4">${p.giocatore.ruolo}</span><br
													class="visible-xs"></td>
											</c:when>
										</c:choose>


										<td class=""><span title="Nome">${p.giocatore.nome}</span></td>

										<td class=""><span title="Squadra">${p.giocatore.squadra} </span></td>

										<td class="text-center"><span title="Voto">6.00 </span></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>















































		<!--Banner pubblicitÃÂ  -->
		<div class="row">
			<div class="box col-lg-12">
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
	<%@ include file="../fragments/footer.html"%>

	<!-- jQuery -->
	<script src="Script/jquery-3.1.1.min.js" type="text/javascript"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/sweetalert.min.js"></script>

	<!-- Table JavaScript library -->
	<script src="js/jquery-1.12.4.js"></script>
	<script src="js/jquery.dataTables.min.js"></script>
	<script src="js/dataTables.bootstrap.min.js"></script>




	<script type="text/javascript">
		$(document).ready(function() {
			$('#tabellaRosa').DataTable();
		});
	</script>
	

</body>
</html>
