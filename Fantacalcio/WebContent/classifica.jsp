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
    <link href="css/sweetalert.css" type="text/css" rel="stylesheet"/>
	<link href="css/sweetalert2.css" type="text/css" rel="stylesheet"/>
	<link href="css/modal.css" type="text/css" rel="stylesheet"/>

<title>Fanta Bomber</title>
</head>

<body>

	<!-- Navigation -->

	
<%@ include file = "../fragments/navbar.html" %>	
	
	
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
							<th class="hidden-xs" title="Giocate">Partite giocate</th>
							<th title="Totale">Totale</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>FC peroni</td>
							<td class="hidden-xs" title="Giocate">$1.38</td>
							<td title="Totale" >-0.01</td>

						</tr>
						<tr>
							<td>FC uuu</td>
							<td class="hidden-xs" title="Giocate">$1.38</td>
							<td title="Totale" >-0.01</td>
						
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
	
	<script src="Script/modal.js"></script>


</body>

</html>
