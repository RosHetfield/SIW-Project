
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
	
	var aggiungi = $('<input id="aggiungi" type="submit" value="Aggiungi" class="btn btn-primary btn-sm" onclick="rosa(\''+g+'\',\'t\')">');
	var rimuovi = $('<input id="rimuovi" type="submit" value="Rimuovi" class="btn btn-danger btn-sm" onclick="rosa(\''+g+'\',\'f\')">')
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
				console.log("ok");
				$('#' + g).find("#aggiungi").remove();
				$('#' + g).find(".text-center").append(rimuovi);
				$('#players_list').append($('#' + g));
				swal({
					title : "Giocatore aggiunto!",
					type : "success",
					confirmButtonText : "Ok",
					text: res.crediti
				
				});
			}
			else if (res.status == 1) {
				swal({
					title : "Crediti insufficenti!",
					type : "warning",
					confirmButtonText : "Ok"
				});
			}
			else if (res.status == 2) {
				swal({
					title : "Numero massimo Portieri raggiunto!",
					type : "warning",
					confirmButtonText : "Ok"
				});
			}
			else if (res.status == 3) {
				swal({
					title : "Numero massimo Difensori raggiunto!",
					type : "warning",
					confirmButtonText : "Ok"
				});
			}
			else if (res.status == 4) { 
				swal({
					title : "Numero massimo Centrocampisti raggiunto!",
					type : "warning",
					confirmButtonText : "Ok"
				});
			}
			else if (res.status == 5) {
				swal({
					title : "Numero massimo Attaccanti raggiunto!",
					type : "warning",
					confirmButtonText : "Ok"
				});
			}
			else if (res.status == 6) {
				$('#' + g).find("#rimuovi").remove();
				$('#' + g).find(".text-center").append(aggiungi);
				$('#tabellaPartecipanti').append($('#' + g));
				swal({
					title : "Giocatore rimosso!",
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