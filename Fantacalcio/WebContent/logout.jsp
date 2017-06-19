<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet"/>
    <!-- Custom CSS -->
	<link href="css/business-casual.css" rel="stylesheet"/>
	<script type="text/javascript">
		setTimeout(function(){
			location.href = "index.html";}
		, 3000);
	</script>
<title>FantaBomber - Log Out</title>
</head>
<body>
<%@ include file = "../fragments/header.html" %>
	<div class="ui-content">
		<div class="ui-page-standard">
			<div class="ui-box medium-padding medium-centered">
				<h1 class="ui-page-title">Log Out</h1>
				<div class="box-ok">
					<p>Log Out effettuato con successo! Attendere prego... <div class="loader"></div> </p>
					 
				</div>
			</div>
		</div>
	</div>
	<%@ include file = "../fragments/footer.html" %>
	<!-- jQuery -->
    <script src="Script/jquery-3.1.1.min.js" type="text/javascript"></script>
    
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>