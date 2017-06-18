
function invita(u, c) {
	
	var successBoolean = false;
	var jsonInvito = {
			utente : u,
			campionato : c
	}
	
	$.ajax({

		async : true,
		type : "POST",
		url : "InvioInvitoController",
		datatype : "json",
		data : {

			invito : JSON.stringify(jsonInvito),

		},
		success : function() {

			$('#' + u).find("#invita").prop('value','In Attesa');
			$('#' + u).find("#invita").prop('disabled','true');
		},
		error : function() {
			
			swal({
				title : "Errore!",
				text : "Impossibile inviare l'invito.",
				type : "error",
				confirmButtonText : "Ok"
			});

		}

	});

}