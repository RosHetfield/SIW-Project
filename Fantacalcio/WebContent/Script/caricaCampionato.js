
function caricaCampionato(c) {
	
	var successBoolean = false;
	var jsonInvito = {
			campionato : c
	}
	
	$.ajax({

		async : true,
		type : "GET",
		url : "CaricaCampionato",
		datatype : "json",
		data : {

			invito : JSON.stringify(jsonInvito),

		},
		success : function(data) {

			swal({
				title : "oooooooooo!",
				text : "Ittttttttttttttt",
				type : "error",
				confirmButtonText : "Ok"
			});
			//$('#' + u).find("#invita").prop('value','In Attesa');
			//$('#' + u).find("#invita").prop('disabled','true');
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

