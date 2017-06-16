<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/sweetalert.css" type="text/css" rel="stylesheet"/>

    <!-- Custom CSS -->
	<link href="css/business-casual.css" rel="stylesheet"/>
<title>FantaBomber - Home</title>
</head>
<body>
<%@ include file = "../fragments/navbar.html" %>







    <div class="container">
    
    		<div class="row">
			<div class="col-xs-5 col-sm-6 col-md-5  box">
				<form id="formLogin" class="register-form"
					onsubmit="return controlLoginUtente(this)" action="Home"
					method="POST">
					<hr>
					<h2 class="intro-text text-center">
						<strong>Login Cliente</strong>
					</h2>
					<hr>

					<div class="form-group">
						<h3>Username</h3>
						<input type="text" name="Username" id="Username"
							class="form-control input-lg" placeholder="Username" tabindex="1"
							required="required">
					</div>

					<h3>Password</h3>
					<div class="form-group">
						<input type="password" class="form-control input-lg" id="Password"
							name="Password" placeholder="Password" tabindex="2"
							required="required">
					</div>


					<hr class="colorgraph">
					<div class="row text-center">

						<div class="col-xs-12 col-md-6">
							<input type="submit" id="login" value="Accedi"
								class="btn btn-default btn-lg" tabindex="3">


						</div>

						<div class="col-xs-12 col-md-6">
							Non hai un account? <a href="registrazione.jsp">Registrati</a>
						</div>

					</div>
				</form>
			</div>
		
		
							<div class="col-xs-2 col-sm-6 col-md-2  "></div>
				
		
		
			<div class="col-xs-5 col-sm-6 col-md-5  box">
				<form id="formLogin" class="register-form"
					onsubmit="return controlLoginUtente(this)" action="Home"
					method="POST">
					<hr>
					<h2 class="intro-text text-center">
						<strong>Login Cliente</strong>
					</h2>
					<hr>

					<div class="form-group">
						<h3>Usernsdfsfgsame</h3>
						<input type="text" name="Username" id="Username"
							class="form-control input-lg" placeholder="Username" tabindex="1"
							required="required">
					</div>

					<h3>Password</h3>
					<div class="form-group">
						<input type="password" class="form-control input-lg" id="Password"
							name="Password" placeholder="Password" tabindex="2"
							required="required">
					</div>


					<hr class="colorgraph">
					<div class="row text-center">

						<div class="col-xs-12 col-md-6">
							<input type="submit" id="login" value="Accedi"
								class="btn btn-default btn-lg" tabindex="3">


						</div>

						<div class="col-xs-12 col-md-6">
							Non hai un account? <a href="registrazione.jsp">Registrati</a>
						</div>

					</div>
				</form>
			</div>
		</div>
    
    
	</div>
	
	
	
	
	
	
	
	
	
<%@ include file = "../fragments/footer.html" %>
	<!-- jQuery -->
    <script src="Script/jquery-3.1.1.min.js" type="text/javascript"></script>
    
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	<script src="js/sweetalert.min.js"></script>
	<script src="Script/RegistrazioneUtente.js"></script>
	
</body>
</html>