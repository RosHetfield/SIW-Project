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
					text : "Nessuna partita da giocare",
					type : "error",
					confirmButtonText : "Ok"
				});
				succ = false;
			}
			if (data == 0) {
				location.href = "Formazione";
				succ = true;
			}
			if (data == 2) {
				swal({
					title : "Mercato Aperto!",
					text : "Impossibile gestire la formazione",
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

function salvaFormazione() {
	var countForm = $("#tbody2 > tr").length;
	var countPanc = $("#tbody3 > tr").length;
	
	if(countForm < 11 || countPanc < 7) {
		swal({
			title : "Attenzione!",
			text : "Completare la formazione",
			type : "warning",
			confirmButtonText : "Ok"
		});
		return;
	}
	
	console.log(countForm);
	console.log(countPanc);
	
	var formazione = [];
	var panchina = [];
	
	for (var i = 0; i < countForm; i++) {
		formazione.push($('#tbody2').children().eq(i).attr('id'))		
	}
	
	for (var j = 0; j < countPanc; j++) {
		panchina.push($('#tbody3').children().eq(j).attr('id'))		
	}
	
	console.log("Formazione " + formazione);
	console.log("Panchina " + panchina);
	
	$.ajax({

		async : true,
		type : "POST",
		url : "SalvaFormazione",
		datatype : "json",
		data : {
			formazioneJson : JSON.stringify(formazione),
			panchinaJson : JSON.stringify(panchina)
		},
		success : function(data) {
			if (data == 0) {
				swal({
					title : "Formazione salvata!",
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

