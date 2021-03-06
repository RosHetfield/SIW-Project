<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Giocatore"%>
<%@ page import="model.Giocatore_in_formazione"%>
<%@ page import="model.Giocatore_in_rosa"%>
<%@ page import="java.util.List"%>

<!doctype html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>FantaBomber - Inserisci formazione</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" />

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<!-- Custom CSS -->
<link href="css/business-casual.css" rel="stylesheet" />
<link href="css/formazioniStyle.css" rel="stylesheet" />


<!-- Navbar CSS -->
<link href="css/sweetalert.css" type="text/css" rel="stylesheet" />
<link href="css/modal.css" type="text/css" rel="stylesheet" />
<link href="css/sweetalert2.css" type="text/css" rel="stylesheet" />








<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="js/sweetalert.min.js"></script>
<script src="js/sweetalert2.min.js"></script>





<style>
#tbody1, #tbody2, #tbody3 > tr{
	border: 1px solid #eee;
	width: 142px;
	list-style-type: none;
	margin: 0;
}



fieldset {
	border: 0;
}

label {
	display: block;
	margin: 30px 0 0 0;
}

select {
	width: 200px;
}

.overflow {
	height: 200px;
}
</style>





<style type="text/css">
.moving-color {
	background-color: #F9F9F9;
}

#tbody1, #tbody2, #tbody3 {
	border: 1px solid #eee;
	width: 142px;
	min-height: 20px;
	list-style-type: none;
	padding: 1em 0 0 0;
}
</style>


</head>
<body>

	<!-- Header/Navigation -->
	<%@ include file="../fragments/navbar.html"%>

	<%@ include file="../fragments/homeNavbar.html"%>


	<div class="col-lg-12 box">
		<div class="col-lg-6 text-center">
		<div class="col-lg-12 text-center">
		<h4>Modulo:</h4>
		</div>
			<select id="myselect">
				<option value="1">4-4-2</option>
				<option value="2">4-3-3</option>
				<option value="3">3-5-1</option>
				<option value="4">3-4-3</option>
			</select>

		</div>
		<div class="col-lg-6 " style="padding-top : 1em;">
			<button type="button" class="btn btn-primary btn-block"
				onclick="salvaFormazione()">Salva formazione</button>

		</div>
	</div>




	<div>
		<div class="col-lg-6 ">
			<table class="  table table-striped table-bordered box"
				id=" players_list">
				<thead>

					<tr class="active">
						<td class="text-center" colspan="8"><h5>Rosa</h5></td>
					</tr>


					<tr class="bg-slate-300">
						<td class="">Ruolo</td>

						<td class="" colspan="1"><span class="hidden-xs">
								Nome</span> <span class="visible-xs" data-toggle="tooltip" title="Nome">N</span>
						</td>

						<td class=""><span class="hidden-xs">
								Squadra</span> <span class="visible-xs" data-toggle="tooltip"
							title="Squadra">S</span></td>
					</tr>

				</thead>


				<tbody id="tbody1" class="connectedSortable ">


					<%
						List<Giocatore> inFormazione = (List<Giocatore>) request.getAttribute("giocatoriInRosa");

						if (inFormazione.size() == 0) {
					%>
					<tr>
						<td colspan="7">Nessun giocatore</td>
					</tr>
					<%
						} else {
					%>
					<tr class="sort-disabled"><td></td><td></td><td></td></tr>
					<c:forEach var="p" items="${giocatoriInRosa}">

						<tr id="${p.nome}" class="${p.ruolo}">

							<c:choose>
								<c:when test="${p.ruolo == 'P'}">
									<td class="valign-top"><span class="label label-1">${p.ruolo}</span><br
										class="visible-xs"></td>
								</c:when>
								<c:when test="${p.ruolo == 'D'}">
									<td class="valign-top"><span class="label label-2">${p.ruolo}</span><br
										class="visible-xs"></td>
								</c:when>
								<c:when test="${p.ruolo == 'C'}">
									<td class="valign-top"><span class="label label-3">${p.ruolo}</span><br
										class="visible-xs"></td>
								</c:when>
								<c:when test="${p.ruolo == 'A'}">
									<td class="valign-top"><span class="label label-4">${p.ruolo}</span><br
										class="visible-xs"></td>

								</c:when>
							</c:choose>


							<td class=""><span class="" data-toggle="tooltip"
								title="Nome">${p.nome}</span></td>

							<td class=""><span class="" data-toggle="tooltip"
								title="Squadra">${p.squadra} </span></td>


						</tr>
					</c:forEach>
					<%
						}
					%>

				</tbody>

			</table>
		</div>

		<div class="col-lg-6 ">
			<table class=" table table-striped table-bordered box"
				id="players_list">
				<thead>

					<tr class="active">
						<td class="text-center" colspan="8"><h5>In Campo</h5></td>
					</tr>


					<tr class="bg-slate-300">
						<td class="">Ruolo</td>

						<td class="" colspan="1"><span class="hidden-xs">
								Nome</span> <span class="visible-xs" data-toggle="tooltip" title="Nome">N</span>
						</td>

						<td class=""><span class="hidden-xs">
								Squadra</span> <span class="visible-xs" data-toggle="tooltip"
							title="Squadra">S</span></td>
					</tr>
				</thead>

				<tbody id="tbody2" class="connectedSortable">

					<tr class="sort-disabled"><td></td><td></td><td></td></tr>
					<c:forEach var="p" items="${giocatoriInFormazione}">

						<tr id="${p.nome}" class="${p.ruolo}">

							<c:choose>
								<c:when test="${p.ruolo == 'P'}">
									<td class="valign-top"><span class="label label-1">${p.ruolo}</span><br
										class="visible-xs"></td>
								</c:when>
								<c:when test="${p.ruolo == 'D'}">
									<td class="valign-top"><span class="label label-2">${p.ruolo}</span><br
										class="visible-xs"></td>
								</c:when>
								<c:when test="${p.ruolo == 'C'}">
									<td class="valign-top"><span class="label label-3">${p.ruolo}</span><br
										class="visible-xs"></td>
								</c:when>
								<c:when test="${p.ruolo == 'A'}">
									<td class="valign-top"><span class="label label-4">${p.ruolo}</span><br
										class="visible-xs"></td>

								</c:when>
							</c:choose>


							<td class=""><span class="" data-toggle="tooltip"
								title="Nome">${p.nome}</span></td>

							<td class=""><span class="" data-toggle="tooltip"
								title="Squadra">${p.squadra} </span></td>

						
						</tr>
						
					</c:forEach>




				</tbody>

				<thead>

					<tr class="active">
						<td class="text-center" colspan="8"><h5>In Panchina</h5></td>
					</tr>


					<tr class="bg-slate-300">
						<td class="">Ruolo</td>

						<td class="" colspan="1"><span class="hidden-xs">
								Nome</span> <span class="visible-xs" data-toggle="tooltip" title="Nome">N</span>
						</td>

						<td class=""><span class="hidden-xs">
								Squadra</span> <span class="visible-xs" data-toggle="tooltip"
							title="Squadra">S</span></td>
					</tr>
				</thead>

				<tbody id="tbody3" class="connectedSortable">
					<tr class="sort-disabled"><td></td><td></td><td></td></tr>
					<c:forEach var="p" items="${giocatoriInPanchina}">


						<tr id="${p.nome}" class="${p.ruolo}">

							<c:choose>
								<c:when test="${p.ruolo == 'P'}">
									<td class="valign-top"><span class="label label-1">${p.ruolo}</span><br
										class="visible-xs"></td>
								</c:when>
								<c:when test="${p.ruolo == 'D'}">
									<td class="valign-top"><span class="label label-2">${p.ruolo}</span><br
										class="visible-xs"></td>
								</c:when>
								<c:when test="${p.ruolo == 'C'}">
									<td class="valign-top"><span class="label label-3">${p.ruolo}</span><br
										class="visible-xs"></td>
								</c:when>
								<c:when test="${p.ruolo == 'A'}">
									<td class="valign-top"><span class="label label-4">${p.ruolo}</span><br
										class="visible-xs"></td>

								</c:when>
							</c:choose>


							<td class=""><span class="" data-toggle="tooltip"
								title="Nome">${p.nome}</span></td>

							<td class=""><span class="" data-toggle="tooltip"
								title="Squadra">${p.squadra} </span></td>


						</tr>
					</c:forEach>

				</tbody>

			</table>

		</div>
	</div>

	<script src="js/bootstrap.min.js"></script>

	<script src="js/sweetalert.min.js"></script>
	<script src="js/sweetalert2.min.js"></script>

	<script src="Script/formazione.js"></script>
	<script src="Script/gestioneFormazione.js"></script>
	<script src="Script/loginCampionato.js"></script>
	<script src="Script/gestioneMercato.js"></script>



	<script type="text/javascript">
		$(document).ready(function() {
			$('#GestioneFormazione').css({
				'background-color' : '#e7e7e7'
			});
		});
	</script>



</body>
</html>