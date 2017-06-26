
function aggiungiNavbarSquadra(){
	
	console.log(campionato);
	
}



function caricaCampionato(c) {
	
	
	
	$.ajax({

		async : true,
		type : "POST",
		url : "CaricaCampionato",
		datatype : "json",
		data : {

			campionato : JSON.stringify(c),

		},
		success : function(data) {

			if (data != 0) {
				
				var squadra=JSON.parse(data);

				location.href="Classifica";
					
			
			}
			
			else{
				swal({
					title : "oooooooooo!",
					text : "Ittttttttttttttt",
					type : "error",
					confirmButtonText : "Ok"
				});
				}		
	
		},
		error : function() {
			
			swal({
				title : "Errore!",
				text : "Impossibile caricare il campionato.",
				type : "error",
				confirmButtonText : "Ok"
			});

		}

	});

}

