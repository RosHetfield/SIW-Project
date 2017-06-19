$(document).ready();
function invita(u, c) {
	
	var jsonInvito = {
			utente : u,
			campionato : c
	}
	
	$.ajax({

		async : true,
		type : "POST",
		url : "InvioInvito",
		datatype : "json",
		data : {

			invito : JSON.stringify(jsonInvito),

		},
		success : function(data) {

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

function rifiutaInvito(u, c, r, d) {
	var jsonInvito = {
			utente : u,
			campionato : c,
			
	}
	$.ajax({

		async : true,
		type : "POST",
		url : "Inviti",
		datatype : "json",
		data : {

			invito : JSON.stringify(jsonInvito),
			risposta : JSON.stringify(r)
		},
		success : function(data) {
			
			$('#' + d).remove();
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

