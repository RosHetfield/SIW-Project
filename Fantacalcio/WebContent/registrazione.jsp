<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/sweetalert.css" type="text/css" rel="stylesheet"/>

    <!-- Custom CSS -->
	<link href="css/business-casual.css" rel="stylesheet"/>
	    
    <title>FantaBomber - Registrazione</title>


</head>

<body>

	<!-- Header/Navigation -->
    <%@ include file = "../fragments/header.html" %>

    <div class="container">
    
			<div class="row">
				<div
					class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3 box">
					<form id="formRegistrazione" class="register-form"
						onsubmit="return registraUtente(this)" action="index.html"
						method="POST">

						<hr>
						<h2 class="intro-text text-center"><strong>Registrazione</strong></h2>
						<hr>
						<div class="row">
							<div class="col-xs-12 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="text" name="Username" id="Username"
										class="form-control input-lg" placeholder="Username" tabindex="1"
										size="15" maxlength="15" required>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="text" name="Nome" id="Nome"
										class="form-control input-lg" placeholder="Nome"
										tabindex="2" size="15" maxlength="15" required>
								</div>
							</div>
						</div>
						<div class="form-group">
							<input type="text" name="Cognome" id="Cognome"
								class="form-control input-lg" placeholder="Cognome"
								tabindex="3" required>
						</div>
						<div class="form-group">
							<input type="email" name="Email" id="Email"
								class="form-control input-lg" placeholder="Email Address"
								tabindex="4" required>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="password" name="Password" id="Password"
										class="form-control input-lg" placeholder="Password"
										tabindex="6" required>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="password" name="Password_confirmation"
										id="Password_confirmation" class="form-control input-lg"
										placeholder="Conferma Password" tabindex="7" required>
								</div>
							</div>
						</div>

						<hr class="colorgraph">
						<div class="row text-center">
							<div class="col-xs-12 col-md-6">
								
								<input type="submit" class="btn btn-default btn-lg"
									tabindex="8" value="Registrati">
							</div>
							
							<div class="col-xs-12 col-md-6">
								Hai già un account? <a href="login.jsp">Accedi</a>
							</div>
						</div>

					</form>
				</div>

		</div>
        
        


<!--Banner pubblicità -->
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
    <!-- /.container -->

    
     <!--include footer -->
 	<%@ include file = "../fragments/footer.html" %>
	
	    
    <!-- Bootstrap Core JavaScript -->
    
    <script src="js/bootstrap.min.js"></script>
	<script src="js/sweetalert.min.js"></script>
	<script src="Script/RegistrazioneUtente.js"></script>
	
    <!-- jQuery -->
    
    <script src="Script/jquery-3.1.1.min.js" type="text/javascript"></script>

</body>

</html>
