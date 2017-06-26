<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>


<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>FantaBomber - Classifica</title>


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


<title>Fanta Bomber</title>
</head>

<body>

	<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed "
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
			<a class="navbar-brand ">FantaBomber</a>

		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<ul class="nav navbar-nav navbar-right">

				<li id="home-btn"><a href="Home">Home</a></li>


				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Campionati <span class="caret"></span></a>
					<ul class="dropdown-menu">

						<% List
						<String> campionati = (List<String>)
						request.getSession().getAttribute("CampionatiUtente"); if
						(campionati.isEmpty()) { %>

						<li><a>Nessun campionato</a></li>

						<% } else { %> <c:forEach var="p" items="${CampionatiUtente}">


							<li><a onclick="caricaCampionato('${p}') ">${p}</a></li>


						</c:forEach> <% } %> 
					</ul></li>




				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">${Username} <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a id="gestioneCampionato" href="#" onclick="">Gestione
								Campionato</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="Inviti">Inviti</a></li>

					</ul></li>




				<li><a class="btn btn-sm btn-info " href="Logout">Log Out</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		<%@ include file = "../fragments/homeNavbar.html" %>
	

	<div class="container">

		<!-- indice giornate -->
		<div class="row">
			<div class="box ">
				<div class="col-lg-12 ">
					<ol class="list-inline">

						<li><button type="button" class="btn btn-sm btn-primary myButton">
								1</button></li>

									
					</ol>
				</div>
			</div>
		</div>


		<!-- tabella classifica -->
		<div class="row ">
			<div class="col-lg-12  box">

				<hr>
				<h2 class="intro-text text-center">Classifica giornata '55'</h2>
				<hr>

				<table id="tabellaClassifica"
					class="table table-striped table-bordered">
					<thead class="bg-slate-300">
						<tr>
							<th>Squadra</th>
							<th class="hidden-xs" title="Voto">pt.</th>
							<th class="hidden-xs" title="Voto">g.</th>
							<th class="hidden-xs" title="Voto">v.</th>
							<th class="hidden-xs" title="Voto">n.</th>
							<th class="hidden-xs" title="Voto">p.</th>
							<th class="hidden-xs" title="Voto">gf.</th>
							<th class="hidden-xs" title="Voto">gs.</th>
							<th class="hidden-xs" title="Voto">dr.</th>
							<th title="Totale">tot.</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>FC peroni</td>
							<td>$1.38</td>
							<td >-0.01</td>
							<td data-title="Vinte" class="numeric">-0.36%</td>
							<td data-title="Pareggiate" class="numeric">$1.39</td>
							<td data-title="Perse" class="numeric">$1.39</td>
							<td data-title="Goal_fatti" class="numeric">$1.38</td>
							<td data-title="Goal_subiti" class="numeric">9,395</td>
							<td data-title="Diff_reti" class="numeric">9,395</td>
							<td data-title="Totale" class="numeric">9,395</td>

						</tr>
						<tr>
							<td data-title="Squadra">FC uuu</td>
							<td data-title="Punti" class="numeric">$1.38</td>
							<td data-title="Giornata" class="numeric">-0.01</td>
							<td data-title="Vinte" class="numeric">-0.36%</td>
							<td data-title="Pareggiate" class="numeric">$1.39</td>
							<td data-title="Perse" class="numeric">$1.39</td>
							<td data-title="Goal_fatti" class="numeric">$1.38</td>
							<td data-title="Goal_subiti" class="numeric">9,395</td>
							<td data-title="Diff_reti" class="numeric">9,395</td>
							<td data-title="Totale" class="numeric">9,395</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>



		<!--Banner pubblicità -->
		<div class="row">
			<div class="box">
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
	<%@ include file = "../fragments/footer.html" %>

	<!-- jQuery -->
	<script src="Script/jquery-3.1.1.min.js" type="text/javascript"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>





	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>



	<script
		src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>



	<script type="text/javascript">
	
		$(document).ready(function() {
			$('#tabellaClassifica').DataTable();
		});
		
	
	</script>
	
	


</body>

</html>
