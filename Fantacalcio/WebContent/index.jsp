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

    <title>Fanta Bomber</title>

</head>

<body>

    <div class="brand">Fanta Bomber</div>

    <!-- Navigation -->
	 <%@ include file = "../fragments/navbar.html" %>
	

    <div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12 text-center">
                    <div id="carousel-example-generic" class="carousel slide">
                        <!-- Indicators -->
                        <ol class="carousel-indicators hidden-xs">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">
                            <div class="item active" style="background-image: url('img/slide-1.jpg');">
                            </div>
                            <div class="item" style="background-image: url('img/slide-2.jpg');">
                            </div>
                            <div class="item" style="background-image: url('img/slide-3.jpg');">
                            </div>
                        </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="icon-prev"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="icon-next"></span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">Cosa
                        <strong>ti offriamo</strong>
                    </h2>
                    <hr>
                    <p>Uno spazio esclusivo solo per la tua lega per giocare con i tuoi amici da desktop e da web mobile.</p>
                    <p>Gestione automatizzata di calcoli e punteggi in un solo click.</p>
                    <p>E molto altro ancora!</p>                    
                </div>
            </div>
        </div>
        
        
        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">Il gioco del
                        <strong>fantacalcio</strong>
                    </h2>
                    <hr>
                    <p>Il fantacalcio è un gioco fantasy sport sul calcio, consistente nell'organizzare e gestire squadre virtuali formate da calciatori reali, scelti fra quelli che giocano il torneo cui il gioco si riferisce(Serie A). </p>
                	<ol>
	                	<li>Lo scopo è quello del guidare una fantasquadra, formata da veri calciatori delle squadre del campionato italiano alla conquista del fantascudetto di Lega.</li>
	                	<li>L'esito di ogni partita si basa sulle reali prestazioni degli 11 calciatori che formano settimanalmente la fantasquadra.</li>
	                	<li>Una lega è costituita da un numero di persone variabile tra 4 e 10: per quanto sia aritmeticamente possibile schierare fino a 20 squadre (quante quelle del campionato di Serie A), 
	                	giocando in più di 10 persone aumenta il rischio per ciascun giocatore di non avere a disposizione un numero sufficiente di calciatori per schierare 11 titolari. 
	                	Ciascun giocatore funge sia da presidente (in occasione dell'asta acquista i calciatori) sia da allenatore della propria fantasquadra.</li>
	                	<li>La rosa di ciascuna fantasquadra è composta da 25 calciatori:
	                		<ul>
	                			<li>3 portieri</li>
	                			<li>8 difensori</li>
	                			<li>8 centrocampisti</li>
	                			<li>6 attaccanti</li>
	                			
	                		</ul>
	                	</li>
	                	<li>Le singole gare di campionato sono giocate da una fantasquadra formata da 11 titolari suddivisi nei rispettivi ruoli in base ai moduli.</li>
	                	
	                	<li>Le fantasquadre si affrontano in una serie di partite il cui esito è determinato dalla somma dei voti assegnati in pagella dai quotidiani (prevalentemente <i><a href="http://www.gazzetta.it/" title="La Gazzetta dello Sport">La Gazzetta dello Sport</a></i> e in misura minore il <a href="http://www.corrieredellosport.it/" title="Corriere dello Sport - Stadio">Corriere dello Sport</a>), 
	                	da siti internet come Sportmediaset e Gazzetta.it e dai punti "bonus" e "malus" dovuti a diverse variabili:
							<ul>
								<li>+3 punti per ogni gol segnato</li>
								<li>+3 punti per ogni rigore parato (portiere)</li>
								<li>+2 punti per ogni rigore segnato</li>
								<li>+1 punto per ogni assist effettuato</li>
								<li>+1 punto per gol vittoria</li>
								<li>-0,5 punti per ogni ammonizione</li>
								<li>+1 portiere imbattuto</li>
								<li>-1 punto per ogni gol subito dal portiere</li>
								<li>-1 punto per ogni espulsione</li>
								<li>-2 punti per ogni autorete</li>
								<li>-3 punti per un rigore sbagliato</li>
							</ul>
						</li>
	                	
	                	<li>La <i>tabella di conversione in gol dei punteggi</i> ottenuti dalla somma di voti e bonus/malus è storicamente la seguente:
							<ul>
								<li>Meno di 66 punti: 0 gol</li>
								<li>Da 66 a 71.5 punti: 1 gol</li>
								<li>Da 72 a 77.5 punti: 2 gol</li>
								<li>Da 78 a 83.5 punti: 3 gol</li>
								<li>Da 84 a 89.5 punti: 4 gol</li>
								<li>Da 90 a 95.5 punti: 5 gol</li>
								<li>Da 96 a 101.5 punti: 6 gol</li>
								<li>E così via ogni 6 punti un gol<br>
								Tuttavia nel corso degli anni la Federazione Fantacalcio ha apportato modifiche alla tabella, portando nella stagione 2002/2003 la soglia per il 3° gol da 78 a 77 punti e assegnando i gol successivi ogni 4 punti (4 gol con 81 punti, 5 con 85 punti, 6 con 89 punti e così via).</li>
							</ul>
						</li>
						
						<li>Nel momento in cui un giocatore nella formazione titolare non ha ricevuto voto, subentra il voto dei giocatori schierati in panchina. Nel caso in cui nessun giocatore tra i titolari o i panchinari riceva votazione subentrerà la riserva d'ufficio, il cui voto sarà considerato essere sempre un 4; 
						tale riserva si può usare solo una volta, se più giocatori non giocano gli altri non avranno punteggio e si giochera in inferiorità numerica. 
						Nel caso in cui un fantallenatore abbia solo giocatori subentrati a gara iniziata e non abbia titolari in un determinato ruolo, 
						il voto viene conteggiato al giocatore subentrato.</li>
						
						<li>Qualora dovesse esserci il rinvio di una o più partite il Regolamento Ufficiale del Fantacalcio prevede per gli scontri lo stand-by della gara, con successiva aggiunta di voti bonus e malus alla ripresa della gara. In caso di sospensione definitiva si attesta il 6 d'ufficio ai partecipanti e il 5,5 ai portieri. 
						Alcune tipologie di fantacalcio, come quelle di Repubblica e Facebook, invece prevedono il 6 d'ufficio per tutti, compresi i portieri.</li>
						
						<li>La classifica del campionato di Lega è stabilita per punteggio, con attribuzione di 3 punti per la partita vinta, 1 punto per la partita pareggiata e zero punti per la partita persa.</li>
						
						<li>Il fantacampionato termina quando sono state giocate tutte le partite previste dal calendario. La squadra col maggior numero di punti è dichiarata "Campione di Lega".</li>
						
						<li>La formazione dovrà essere comunicata a seconda dei regolamenti o entro l'inizio della prima partita in programma nella giornata o trenta minuti prima di tale orario. Nel caso in cui la formazione non venga inserita prima del termine stabilito, diverrà attiva la formazione schierata nella giornata precedente, senza alcuna penalizzazione.</li>			
                	</ol>
                
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


<!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	<script src="js/sweetalert.min.js"></script>
	<script src="Script/RegistrazioneUtente.js"></script>
	

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>
	

    <!-- jQuery -->  
    <script src="Script/jquery-3.1.1.min.js" type="text/javascript"></script>
    
</body>
</html>
