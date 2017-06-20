
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

			console.log(data);
			if (data == 0) {
			swal({
				title : "oooooooooo!",
				text : "Ittttttttttttttt",
				type : "error",
				confirmButtonText : "Ok"
			});
			}
			
			
			var a= data['campionato'];
			console.log(a);
	
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

