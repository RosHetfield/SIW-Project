function mercato() {

	var succ = false;
	$.ajax({

		async : false,
		type : "POST",
		url : "Mercato",
		datatype : "json",
		data : {},
		success : function(data) {
			if (data == 0) {

				succ = true;
			}
			if (data == 1) {
				swal({
					title : "Attenzione!",
					text : "Mercato Chiuso ",
					type : "error",
					confirmButtonText : "Ok"
				});
				success = false;
			}
		},
		error : function(data) {
			succ = false;
		}
	});
	return Boolean(succ)
}

function aperturaMercato() {

	if ($('#mercato').prop("checked")) {
		var r = 't';
	} else {
		var r = 'f';
	}

	$.ajax({

		async : true,
		type : "POST",
		url : "AperturaMercato",
		datatype : "json",
		data : {
			risposta : JSON.stringify(r)
		},
		success : function(data) {
			if (data == 0) {
				swal({
					title : "Mercato Aperto!",
					type : "success",
					confirmButtonText : "Ok"
				});

			} else if (data == 1) {
				swal({
					title : "Mercato Chiuso!",
					type : "success",
					confirmButtonText : "Ok"
				});

			} else if (data == 2) {
				swal({
					title : "Impossibile aprire il mercato!",
					text : "Partita non conclusa.",
					type : "error",
					confirmButtonText : "Ok"
				});
				$('#mercato').prop("checked", false);
			}
		},
		error : function(data) {
			swal({
				title : "Errore!",
				text : "Impossibile completare l'operazione",
				type : "error",
				confirmButtonText : "Ok"
			});
		}
	});
}

function rosa(g, r) {
	$(document).ready(function() {
		$.ajax({

			async : false,
			type : "POST",
			url : "GestioneMercato",
			datatype : "json",
			data : {
				giocatore : JSON.stringify(g),
				risposta : JSON.stringify(r)
			},
			success : function(data) {

				var res = JSON.parse(data);

				if (res.status == 0) {
					var table = $('#tabellaPartecipanti').DataTable();
					table.row('#' + g).remove().draw(false);
					swal({
						title : "Giocatore " + g + " aggiunto!",
						type : "success",
						confirmButtonText : "Ok",
						text : "Crediti rimanenti: " + res.crediti

					});
					setTimeout(function() {
						location.href = "Mercato";
					}, 2000);
				} else if (res.status == 1) {
					swal({
						title : "Crediti insufficenti!",
						type : "warning",
						confirmButtonText : "Ok"
					});
				} else if (res.status == 2) {
					swal({
						title : "Numero massimo Portieri raggiunto!",
						type : "warning",
						confirmButtonText : "Ok"
					});
				} else if (res.status == 3) {
					swal({
						title : "Numero massimo Difensori raggiunto!",
						type : "warning",
						confirmButtonText : "Ok"
					});
				} else if (res.status == 4) {
					swal({
						title : "Numero massimo Centrocampisti raggiunto!",
						type : "warning",
						confirmButtonText : "Ok"
					});
				} else if (res.status == 5) {
					swal({
						title : "Numero massimo Attaccanti raggiunto!",
						type : "warning",
						confirmButtonText : "Ok"
					});
				} else if (res.status == 6) {
					var table = $('#players_list');
					table.find("#" + g).remove();
					swal({
						title : "Giocatore " + g + " rimosso!",
						type : "success",
						confirmButtonText : "Ok",
						text : "Crediti rimanenti: " + res.crediti
					});
					setTimeout(function() {
						location.href = "Mercato";
					}, 2000);
				}
			},
			error : function(data) {
				swal({
					title : "Errore!",
					text : "Impossibile completare l'operazione",
					type : "error",
					confirmButtonText : "Ok"
				});
			}
		});

	});
}

function salvaRosa() {
	$(document).ready(function() {
		$.ajax({

			async : true,
			type : "POST",
			url : "SalvaRosa",
			datatype : "json",
			data : {},
			success : function(data) {
				if (data == 0) {
					swal({
						title : "Rosa salvata!",
						text : "La tua rosa è completa! ",
						type : "success",
						confirmButtonText : "Ok"
					});
				}
				if (data == 1) {
					swal({
						title : "Rosa salvata!",
						text : "Attenzione, la tua rosa non è completa!",
						type : "warning",
						confirmButtonText : "Ok"
					});
				}
			},
			error : function(data) {
				swal({
					title : "Errore!",
					text : "Impossibile salvare la rosa!",
					type : "error",
					confirmButtonText : "Ok"
				});
			}
		});
	});
}

function ruolo(r) {

	$.ajax({

		async : true,
		type : "GET",
		url : "Mercato",
		datatype : "json",
		data : {
			ruolo : JSON.stringify(r)
		},
		success : function(data) {
			location.href = "Mercato";

		},
		error : function(data) {
			swal({
				title : "Errore!",
				text : "Impossibile completare l'operazione",
				type : "error",
				confirmButtonText : "Ok"
			});
		}
	});

}