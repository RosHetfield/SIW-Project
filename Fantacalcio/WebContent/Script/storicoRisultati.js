function caricaGiornata(g) {

		$.ajax({

			async : true,
			type : "GET",
			url : "Risultati",
			datatype : "json",
			data : {

				giornata : JSON.stringify(g)
			},
			success : function(data) {
				location.href = "Risultati";
			},
			error : function(data) {
				swal({
					title : "Errore!",
					text : "Impossibile caricare i risultati!",
					type : "error",
					confirmButtonText : "Ok"
				});
			}
		});

}
