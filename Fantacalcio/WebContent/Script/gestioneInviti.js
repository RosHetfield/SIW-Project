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

			$('#' + u).find("#invita").prop('value', 'In Attesa');
			$('#' + u).find("#invita").prop('disabled', 'true');
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

function rifiutaInvito(u, c, r) {
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

			$('#' + u).remove();
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

function accettaInvito(u, c, r) {
	var jsonInvito = {
		utente : u,
		campionato : c,
	}

	swal({
		title : 'Crea Squadra',
		type : "input",
		showCancelButton : true,
		showLoaderOnConfirm : true,
		allowOutsideClick : false,
		closeOnConfirm : false,
		inputPlaceholder : "Squadra",
		animation : "slide-from-top"
	}, function(inputValue) {
		if (inputValue === "") {
			swal.showInputError("Inserisci il nome della tua squadra!");
			return false
		}
		$.ajax({
			async : true,
			type : "POST",
			url : "Inviti",
			datatype : "json",
			data : {
				invito : JSON.stringify(jsonInvito),
				risposta : JSON.stringify(r),
				squadra : JSON.stringify(inputValue)
			},
			success : function(data) {
				if (data == 0) {
					swal({
						title : "Squadra creata!",
						type : "success",
						confirmButtonText : "Ok"
					});

					$('#' + u).remove();
				} else if (data == 1) {
					swal({
						title : "Squadra esistente!",
						type : "warning",
						confirmButtonText : "Riprova"
					});

				}
			},
			error : function(data) {
				swal({
					title : "Errore!",
					text : "Impossibile creare la squadra.",
					type : "error",
					confirmButtonText : "Riprova"
				});
			}
		})
	});

}
