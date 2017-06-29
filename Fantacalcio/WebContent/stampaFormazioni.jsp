<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Giocatore_in_formazione"%>
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
								class="btn btn-primary  btn-sm myButton  ">1</button></li>

					</ol>
				</div>
			</div>
		</div>
	</div>



	<div class="container">
		<div class=" box">


			<%
				Set<Giocatore_in_formazione> formazioni = (Set<Giocatore_in_formazione>) request
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
									<td colspan="8">In campo</td>
								</tr>

								<tr class="bg-slate-300">

									<td class="text-center hidden-xs">Ruolo</td>


									<td >Nome Calciatore</td>


									<td class="text-center"><span class="hidden-xs">
											Squadra</span> <span class="visible-xs" data-toggle="tooltip"
										title="Voto">V</span></td>

								</tr>

							</thead>
							<tbody>


							<c:forEach var="g" items="${giocatoriUltima}">
								

								<tr class="role-1 ">
									<td class="valign-top" colspan="3"><span
										class="label label-1">${g.giocatoreInRosa.giocatore.ruolo} </span></td>


									<td class="text-center"><span class=""
										data-toggle="tooltip" title="Voto">${g.giocatoreInRosa.giocatore.nome} </span></td>

									<td class="text-center"><span class=""
										data-toggle="tooltip" title="Fantavoto">6.00 </span></td>


								</tr>

							</c:forEach>

							</tbody>
							<thead>

								<tr class="active">
									<td colspan="8">In panchina</td>
								</tr>


								<tr class="bg-slate-300">

									<td class="text-center hidden-xs">Ruolo</td>


									<td >Nome Calciatore</td>


									<td class="text-center"><span class="hidden-xs">
											Squadra</span> <span class="visible-xs" data-toggle="tooltip"
										title="Voto">V</span></td>

								</tr>
							</thead>
							<tbody>




								<tr class="role-1 ">
									<td class="valign-top" colspan="3"><span
										class="label label-1">P</span></td>


									<td class="text-center"><span class=""
										data-toggle="tooltip" title="">Neto</span></td>

									<td class="text-center"><span class=""
										data-toggle="tooltip" title="">- </span></td>

								</tr>

							</tbody>

						</table>
					</div>

				</c:forEach>






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

	<script>
		$(document).ready(function() {
			$('[data-toggle="tooltip"]').tooltip();
		});
	</script>
</body>
</html>