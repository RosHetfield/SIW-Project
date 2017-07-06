function creaGiornata() {
	
	var currentDate = $( "#datepicker" ).datepicker( "getDate" );

	if(currentDate.getTime() <= $.now()) {
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
			console.log(res);
			if(res.status == 0) {				
				swal({
					title : "Creata!",
					text : "Giornata " + res.giornata + " creata!",
					type : "success",
					confirmButtonText : "Ok"
				});
				$('#mercato').prop('checked',false);
			}
			else if(res.status == 1) {
				swal({
					title : "Attenzione!",
					text : "Giornata " + res.giornata + " già creata!",
					type : "warning",
					confirmButtonText : "Ok"
				});
			}
			else if(res.status == 2) {
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
	$.ajax({

		async : true,
		type : "GET",
		url : "CalcolaRisultati",
		datatype : "json",
		data : { },
		success : function(data) {
			
			/*if(data == 1) {
				swal({
					title : "Attenzione!",
					text : "Nessuna giornata da calcolare.",
					type : "warning",
					confirmButtonText : "Ok"
				});
			}*/
		},
		error : function() {

			swal({
				title : "Errore!",
				text : "Impossibile eseguire l'operazione.",
				type : "error",
				confirmButtonText : "Ok"
			});

		}

	});
}