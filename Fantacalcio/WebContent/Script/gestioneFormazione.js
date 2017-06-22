function checkFormazione() {
	console.log("sono la caccaaaaaaa");
	var succ = false;
	$.ajax({

		async : false,
		type : "POST",
		url : "Formazione",
		datatype : "json",
		data : {},
		success : function(data) {

			if (data == 1) {

				succ = true;
			}
			if (data == 0) {

				swal({
					title : "Attenzione!",
					text : "Mercato Chiuso ",
					type : "error",
					confirmButtonText : "Ok"
				});
				success = false;
			}
			if (data == 2) {
				swal({
					title : "Attenzione!",
					text : "Inserimento formazione Chiuso ",
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

