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

    <!-- Fonts -->
    
    <title>FantaBomber - Log In</title>

</head>

<body>

    <!-- Header/Navigation -->
    <%@ include file = "../fragments/header.html" %>

    <div class="container">
    
		<div class="row">
				<div
					class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3 box">
					<form id="formLogin" class="register-form"
						onsubmit="return controlLoginUtente(this)" action="" method="POST">
						<hr>
						<h2 class="intro-text text-center"><strong>Login Cliente</strong></h2>
						<hr>

						<div class="form-group">
							<h3>Username</h3>
							<input type="text" name="Username" id="Username"
								class="form-control input-lg" placeholder="Username"
								tabindex="1" required="required">
						</div>
						
						<h3>Password</h3>
						<div class="form-group">
							<input type="password" class="form-control input-lg"
								id="Password" name="Password" placeholder="Password"
								tabindex="2" required="required">
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
	
    <!-- jQuery -->
    
    <script src="Script/jquery-3.1.1.min.js" type="text/javascript"></script>
	    
    <!-- Bootstrap Core JavaScript -->
    
    <script src="js/bootstrap.min.js"></script>
	<script src="js/sweetalert.min.js"></script>
	<script src="Script/LoginUtente.js"></script>
	


</body>

</html>
