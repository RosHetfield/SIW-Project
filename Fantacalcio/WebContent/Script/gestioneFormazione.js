function checkFormazione() {
	console.log("sono la caccaaaaaaa");
	var succ = false;
	$.ajax({

		async : true,
		type : "POST",
		url : "Formazione",
		datatype : "json",
		data : {},
		success : function(data) {
			var res = JSON.parse(data);
			if (data == 1) {

				swal({
					title : "Attenzione!",
					text : "Nessuna Partita da giocare ",
					type : "error",
					confirmButtonText : "Ok"
				});
				succ = false;
			}
			if (data == 0) {
				console.log("aviss i trasr")
				succ = true;
			}
			if (data == 2) {
				swal({
					title : "Attenzione!",
					text : "Inserimento formazione Chiuso ",
					type : "error",
					confirmButtonText : "Ok"
				});
				succ = false;

			}
			if (data == 3) {
				console.log("dda");
				swal({
					title : "Attenzione!",
					text : "Rosa non completa",
					type : "error",
					confirmButtonText : "Ok"
				});
				succ = false;
			}
		},
		error : function(data) {
			succ = false;
		}
	});
	return Boolean(succ)
}





function aperturaFormazione() {
	
	if($('#formazione_id').prop("checked")) {
		var r = 't';
	}
	else {
		var r = 'f';
	}
	
	$.ajax({

		async : true,
		type : "POST",
		url : "AperturaFormazione",
		datatype : "json",
		data : {
			risposta : JSON.stringify(r)
		},
		success : function(data) {
			if (data == 0) {
				swal({
					title : "Formazione Aperto!",
					type : "success",
					confirmButtonText : "Ok"
				});

			}
			 if (data == 1) {
				swal({
					title : "Formazione Chiuso!",
					type : "success",
					confirmButtonText : "Ok"
				});
			}
			 if (data == 2) {
					swal({
						title : "Mercato Aperto!",
						text : "Inserisci alla chiusura del mercato",
						type : "error",
						confirmButtonText : "Ok"
					});
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

