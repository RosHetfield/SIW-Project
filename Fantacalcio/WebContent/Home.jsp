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
    
    		<div class="row ">
			<div class="col-lg-6 ">
				<form id="formCreaCampionato" class="register-form box"
					onsubmit="return registraCampionato(this)" action=""
					method="POST">
					<hr>
					<h2 class="intro-text text-center">
						<strong>Crea il tuo campionato</strong>
					</h2>
					<hr>

					<div class="form-group">
						<h3>Nome Campionato</h3>
						<input type="text" name="Nome_Campionato" id="Nome_Campionato"
							class="form-control input-lg" placeholder="Nome Campionato" tabindex="1"
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

						<div class="col-xs-12 col-md-12">
							<input type="submit" id="camp" value="Crea"
								class="btn btn-default btn-lg" tabindex="3">

						</div>

						
					</div>
				</form>
			</div>
		
		
		
		
			<div class="col-lg-6  ">
				<form id="formLogin" class="register-form box"
					onsubmit="" action=""
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
    
    
    
    
    
    <div class="row">
            <div class="box">
                
                	<hr>
					<h2 class="intro-text text-center">
						<strong>Campionati esistenti</strong>
					</h2>
					<hr>
					
					<div>
					
					
					</div>
            </div>
        </div>
        
        
        
        
        
        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">Build a website
                        <strong>worth visiting</strong>
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
	
	
	
	
	
	
	
	
	
<%@ include file = "../fragments/footer.html" %>
	<!-- jQuery -->
    <script src="Script/jquery-3.1.1.min.js" type="text/javascript"></script>
    
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	<script src="js/sweetalert.min.js"></script>
	<script src="Script/CreaCampionato.js"></script>
	
</body>
</html>