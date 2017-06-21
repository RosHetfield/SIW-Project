
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
	
	if($('#mercato').prop("checked")) {
		var r = 't';
	}
	else {
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
			}
			else if (data == 1) {
				swal({
					title : "Mercato Chiuso!",
					type : "success",
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

function rosa(g, r) {
	
	
	$.ajax({

		async : true,
		type : "POST",
		url : "AperturaMercato",
		datatype : "json",
		data : {
			giocatore : stringify(g),
			risposta : JSON.stringify(r)
		},
		success : function(data) {
			if (data == 0) {
				swal({
					title : "Mercato Aperto!",
					type : "success",
					confirmButtonText : "Ok"
				});
			}
			else if (data == 1) {
				swal({
					title : "Mercato Chiuso!",
					type : "success",
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