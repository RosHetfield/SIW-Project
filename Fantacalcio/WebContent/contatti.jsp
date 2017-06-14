<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet"/>

    <!-- Custom CSS -->
	<link href="css/business-casual.css" rel="stylesheet"/>

    <title>FantaBomber - Contatti</title>
</head>

<body>

    <!-- Navigation -->
	<%@ include file = "../fragments/header.html" %>

    <div class="container">
    
	        <div class="row" id="map">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center"><strong>Sede legale</strong>
                    </h2>
                    <hr>
                </div>
                <div class="col-md-8">
                    <!-- Embedded Google Map using an iframe - to select your location find it on Google maps and paste the link as the iframe src. If you want to use the Google Maps API instead then have at it! -->
                    <iframe width="100%" height="400" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d769.5102887073058!2d16.28389888810127!3d39.5135608333388!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133f765bcc905621%3A0x4d33daef2fc9cc0c!2sCorso+Vittorio+Veneto%2C+55%2C+87043+Bisignano+CS!5e0!3m2!1sit!2sit!4v1490802081704"></iframe>
                
                </div>
                <div class="col-md-4">
                    <p>Telefono:
                        <strong>123.456.7890</strong>
                    </p>
                    <p>Email 1:
                        <strong><a href="mailto:giuseppe.ritacco93@gmail.com"> giuseppe.ritacco93@gmail.com</a></strong>
                    </p>
                     <p>Email 2:
                        <strong><a href="mailto:isignano93@yahoo.it"> bisignano93@yahoo.it</a></strong>
                    </p>
                    <p>Indirizzo:
                        <strong>55 Corso Vittorio Veneto
                            <br>Bisignano(cs), CAP 87043</strong>
                    </p>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

        <div class="row" id="contatto">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center"><strong>Contattaci</strong>
                    </h2>
                    <hr>
                    <p>Inviaci un feedback o una segnalazione</p>
                    <form role="form">
                        <div class="row">
                            <div class="form-group col-lg-4">
                                <label>Nome</label>
                                <input type="text" class="form-control">
                            </div>
                            <div class="form-group col-lg-4">
                                <label>Email</label>
                                <input type="email" class="form-control">
                            </div>
                            <div class="form-group col-lg-4">
                                <label>Telefono</label>
                                <input type="tel" class="form-control">
                            </div>
                            <div class="clearfix"></div>
                            <div class="form-group col-lg-12">
                                <label>Messaggio</label>
                                <textarea class="form-control" rows="6"></textarea>
                            </div>
                            <div class="form-group col-lg-12">
                                <input type="hidden" name="save" value="contact">
                                <button type="submit" class="btn btn-default">Invia</button>
                            </div>
                        </div>
                    </form>
                </div>
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


</body>

</html>
