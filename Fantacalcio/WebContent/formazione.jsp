<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.Giocatore"%>
<%@ page import="model.Giocatore_in_formazione"%>
<%@ page import="model.Giocatore_in_rosa" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Set"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>FantaBomber - Formazioni</title>




<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" />

  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  
<!-- Custom CSS -->
<link href="css/business-casual.css" rel="stylesheet" />
<link href="css/formazioniStyle.css" rel="stylesheet" />


    <link href="css/sweetalert.css" type="text/css" rel="stylesheet"/>
	<link href="css/sweetalert2.css" type="text/css" rel="stylesheet"/>

  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	<script src="js/sweetalert.min.js"></script>
	<script src="js/sweetalert2.min.js"></script>
	
  
<style>

		  #tbody1, #tbody2,#tbody3 {
    border: 1px solid #eee;
    width: 142px;
    min-height: 20px;
    list-style-type: none;
    margin: 0;
    padding: 5px 0 0 0;
	float:left;
    margin-right: 10px;
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

tbody>tr {
	min-height: 10px;
	margin : 1em;
	padding: 1em;
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
	<%@ include file="../fragments/header.html"%>

	
	<div class="  col-lg-12 ">
		<div class="col-lg-6 box">
		<select id="myselect">
			<option value="1">4-4-2</option>
			<option value="2">4-3-3</option>
			<option value="3">3-5-1</option>
			<option value="4">3-4-3</option>
		</select>
		
	</div>
		<div class="col-lg-6 box">
		    <button type="button" class="btn btn-primary btn-block" onclick="salvaFormazione()">Salva formazione</button>
		
	</div>
	</div>




	<div>
		<div class="col-lg-6 ">
			<table class="  table table-striped table-bordered box"
				id=" players_list">
				<thead>

					<tr class="active">
						<td colspan="8">Rosa</td>
					</tr>


					<tr class="bg-slate-300">
						<td>Ruolo</td>

						<td class="text-center" colspan="1"><span class="hidden-xs">
								Nome</span> <span class="visible-xs" data-toggle="tooltip" title="Nome">N</span>
						</td>

						<td class="text-center"><span class="hidden-xs">
								Squadra</span> <span class="visible-xs" data-toggle="tooltip"
							title="Squadra">S</span></td>
					</tr>

				</thead>


				<tbody id="tbody1" class="connectedSortable ">


							<%
								Set<Giocatore_in_rosa> inFormazione = (Set<Giocatore_in_rosa>) request.getAttribute("giocatoriInRosa");

								if (inFormazione.size() == 0) {
							%>
							<tr>
								<td colspan="7">Nessun giocatore</td>
							</tr>
							<%
								} else {
							%>
							<c:forEach var="p" items="${giocatoriInRosa}">


								<tr id="${p.giocatore.nome}" class="${p.giocatore.ruolo}">

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


									<td class=""><span class="" data-toggle="tooltip"
										title="Nome">${p.giocatore.nome}</span></td>

									<td class=""><span class="" data-toggle="tooltip"
										title="Squadra">${p.giocatore.squadra} </span></td>

		
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
						<td colspan="8">In Campo</td>
					</tr>


					<tr class="bg-slate-300">
						<td>Ruolo</td>

						<td class="text-center" colspan="1"><span class="hidden-xs">
								Nome</span> <span class="visible-xs" data-toggle="tooltip" title="Nome">N</span>
						</td>

						<td class="text-center"><span class="hidden-xs">
								Squadra</span> <span class="visible-xs" data-toggle="tooltip"
							title="Squadra">S</span></td>
					</tr>
				</thead>

				<tbody id="tbody2" class="connectedSortable">
					
		

				


				</tbody>

				<thead>

					<tr class="active">
						<td colspan="8">In Panchina</td>
					</tr>


					<tr class="bg-slate-300">
						<td>Ruolo</td>

						<td class="text-center" colspan="1"><span class="hidden-xs">
								Nome</span> <span class="visible-xs" data-toggle="tooltip" title="Nome">N</span>
						</td>

						<td class="text-center"><span class="hidden-xs">
								Squadra</span> <span class="visible-xs" data-toggle="tooltip"
							title="Squadra">S</span></td>
					</tr>
				</thead>

				<tbody id="tbody3" class="connectedSortable">
			
				</tbody>

			</table>

		</div>
	</div>

<script src="js/bootstrap.min.js"></script>
<script src="Script/formazione.js"></script>
<script src="Script/gestioneFormazione.js"></script>



</body>
</html>