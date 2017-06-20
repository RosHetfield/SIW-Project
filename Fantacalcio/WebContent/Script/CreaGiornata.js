function creaGiornata() {

	$.ajax({

		async : true,
		type : "POST",
		url : "CreaPartita",
		datatype : "json",
		data : { },
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
