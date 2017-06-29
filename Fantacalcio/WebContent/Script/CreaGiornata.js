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
