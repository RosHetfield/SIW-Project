function creaGiornata() {

	var currentDate = $("#datepicker").datepicker("getDate");

	if (currentDate.getTime() <= $.now()) {
		swal({
			title : "Attenzione!",
			text : "Inserire una data valida",
			type : "warning",
			confirmButtonText : "Ok"
		});
		return;
	}

	$.ajax({

		async : true,
		type : "POST",
		url : "CreaPartita",
		datatype : "json",
		data : {
			jsonData : JSON.stringify(currentDate)
		},
		success : function(data) {

			var res = JSON.parse(data);
			if (res.status == 0) {
				swal({
					title : "Creata!",
					text : "Giornata " + res.giornata + " creata!",
					type : "success",
					confirmButtonText : "Ok"
				});
				$('#mercato').prop('checked', false);
			} else if (res.status == 1) {
				swal({
					title : "Attenzione!",
					text : "Giornata " + res.giornata + " già creata!",
					type : "warning",
					confirmButtonText : "Ok"
				});
			} else if (res.status == 2) {
				swal({
					title : "Impossibile creare la giornata!",
					text : "Calcolare la giornata " + res.giornata,
					type : "warning",
					confirmButtonText : "Ok"
				});
			}
		},
		error : function() {

			swal({
				title : "Errore!",
				text : "Impossibile creare la giornata.",
				type : "error",
				confirmButtonText : "Ok"
			});

		}

	});
}

function calcola() {
	var s;
	$.ajax({

		async : false,
		type : "GET",
		url : "CalcolaRisultati",
		datatype : "json",
		data : {},
		success : function(data) {
			s = true;

			if (data == 1) {
				s = false;
				swal({
					title : "Attenzione!",
					text : "Nessuna giornata da calcolare.",
					type : "warning",
					confirmButtonText : "Ok"
				});

			}
			else if (data == 2) {
				s = false;
				swal({
					title : "Attenzione!",
					text : "Partita non ancora giocata.",
					type : "warning",
					confirmButtonText : "Ok"
				});

			}
		},
		error : function() {
			s = false;

			swal({
				title : "Errore!",
				text : "Impossibile eseguire l'operazione.",
				type : "error",
				confirmButtonText : "Ok"
			});
		}
	});
	return Boolean(s);

}